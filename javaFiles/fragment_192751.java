@implementation QTKitCaptureDecompressedVideoOutput

- (QTKitCaptureDecompressedVideoOutput *)initWithEnv:(JNIEnv *) env javaObject:(jobject) javaObjectRef {
    [super init];
    // Save a reference to the VM
    (*env)->GetJavaVM(env,&g_vm);
    // Create a global reference to this object so we can access it later
    objectRef = (*env)->NewGlobalRef(env,javaObjectRef);

    return self;
}

- (void)captureOutput:(QTCaptureOutput *)captureOutput didOutputVideoFrame:(CVImageBufferRef)videoFrame withSampleBuffer:(QTSampleBuffer *)sampleBuffer fromConnection:(QTCaptureConnection *)connection {
    // Move into Java to deliver the data
    JNIEnv *env;
    (*g_vm)->AttachCurrentThread (g_vm, (void **) &env, NULL);

    void * rawData = [sampleBuffer bytesForAllSamples];
    int length = [sampleBuffer lengthForAllSamples];
    QTFormatDescription * formatDescription = [sampleBuffer formatDescription];
    QTTime duration = [sampleBuffer duration];

    float frameDuration = duration.timeValue/duration.timeScale;
    float fps = 1/frameDuration;

    jint format = [formatDescription formatType];
    NSValue * pixelSize = [formatDescription attributeForKey:QTFormatDescriptionVideoEncodedPixelsSizeAttribute];
    NSSize size = [pixelSize sizeValue];
    jint width = size.width;
    jint height = size.height;
    //NSLog(@"Outputting frame sized %d x %d of length %d with format: %#x",width,height,length,format);

    switch (format) {
            // 8 bit codecs
        case kCVPixelFormatType_1Monochrome:
        case kCVPixelFormatType_2Indexed:
        case kCVPixelFormatType_4Indexed:
        case kCVPixelFormatType_8Indexed:
        case kCVPixelFormatType_1IndexedGray_WhiteIsZero:
        case kCVPixelFormatType_2IndexedGray_WhiteIsZero:
        case kCVPixelFormatType_4IndexedGray_WhiteIsZero:
        case kCVPixelFormatType_8IndexedGray_WhiteIsZero:
        case kCVPixelFormatType_422YpCbCr8:
        case kCVPixelFormatType_4444YpCbCrA8:
        case kCVPixelFormatType_4444YpCbCrA8R:
        case kCVPixelFormatType_444YpCbCr8:
        case kCVPixelFormatType_420YpCbCr8Planar:
        case kCVPixelFormatType_422YpCbCr_4A_8BiPlanar:
        case kCVPixelFormatType_24RGB:
        case kCVPixelFormatType_24BGR:
        default:
        {
            // Re-use the existing array if possible
            if (byteFrameData == nil || (*env)->GetArrayLength(env,byteFrameData) < length) {
                // Clean up the previously allocated global reference
                if (byteFrameData != nil) {
                    (*env)->DeleteGlobalRef(env,byteFrameData);
                    byteFrameData = nil;
                }
                // Create an appropriately sized byte array to hold the data
                byteFrameData = (*env)->NewGlobalRef(env,(*env)->NewByteArray(env,length));
            }
            if (byteFrameData) {
                // Copy the raw data into the byteArray
                (*env)->SetByteArrayRegion(env,byteFrameData,0,length,rawData);

                // Get the class reference for our object
                jclass classRef = (*env)->GetObjectClass(env,objectRef);
                // Get the pushFrame methodId
                jmethodID methodId = (*env)->GetMethodID(env,classRef,"pushFrame","([BIIIF)V");
                // Call pushFrame with the byte array
                (*env)->CallVoidMethod(env,objectRef,methodId,byteFrameData,format,width,height,fps);
            }
            break;
        }   
            // 16 bit (short) storage of values
        case kCVPixelFormatType_16BE555:
        case kCVPixelFormatType_16LE555:
        case kCVPixelFormatType_16LE5551:
        case kCVPixelFormatType_16BE565:
        case kCVPixelFormatType_16LE565:
        case kCVPixelFormatType_16Gray:
        case kCVPixelFormatType_422YpCbCr16:
        case kCVPixelFormatType_422YpCbCr10:
        case kCVPixelFormatType_444YpCbCr10:
        {
            // Re-use the existing array if possible
            if (shortFrameData == nil || (*env)->GetArrayLength(env,shortFrameData) < length/2) {
                // Clean up the previously allocated global reference
                if (shortFrameData != nil) {
                    (*env)->DeleteGlobalRef(env,shortFrameData);
                    shortFrameData = nil;
                }
                // Create an appropriately sized byte array to hold the data
                shortFrameData = (*env)->NewGlobalRef(env,(*env)->NewShortArray(env,length/2));
            }
            if (shortFrameData) {
                // Copy the raw data into the byteArray
                (*env)->SetShortArrayRegion(env,shortFrameData,0,length/2,rawData);

                // Get the class reference for our object
                jclass classRef = (*env)->GetObjectClass(env,objectRef);
                // Get the pushFrame methodId
                jmethodID methodId = (*env)->GetMethodID(env,classRef,"pushFrame","([SIIIF)V");
                // Call pushFrame with the short array
                (*env)->CallVoidMethod(env,objectRef,methodId,shortFrameData,format,width,height,fps);          
            }
            break;
        }   
            // 32 bit (int) storage of values
        case kCVPixelFormatType_32ABGR:
        case kCVPixelFormatType_32AlphaGray:
        case kCVPixelFormatType_32ARGB:
        case kCVPixelFormatType_32BGRA:
        case kCVPixelFormatType_32RGBA:
        {
            // Re-use the existing array if possible
            if (intFrameData == nil || (*env)->GetArrayLength(env,intFrameData) < length/4) {
                // Clean up the previously allocated global reference
                if (intFrameData != nil) {
                    (*env)->DeleteGlobalRef(env,intFrameData);
                    intFrameData = nil;
                }
                // Create an appropriately sized byte array to hold the data
                intFrameData = (*env)->NewGlobalRef(env,(*env)->NewIntArray(env,length/4));
            }
            if (intFrameData) {
                // Copy the raw data into the byteArray
                (*env)->SetByteArrayRegion(env,intFrameData,0,length/4,rawData);

                // Get the class reference for our object
                jclass classRef = (*env)->GetObjectClass(env,objectRef);
                // Get the pushFrame methodId
                jmethodID methodId = (*env)->GetMethodID(env,classRef,"pushFrame","([IIIIF)V");
                // Call pushFrame with the int array
                (*env)->CallVoidMethod(env,objectRef,methodId,intFrameData,format,width,height,fps);
            }
            break;
        }
    }

    // Detatch from Java
    (*g_vm)->DetachCurrentThread (g_vm);
}

/* Clean up java references so they can be properly GCed in java */
- (void) dealloc {

    // Attach to java so we can release references
    JNIEnv *env;
    (*g_vm)->AttachCurrentThread (g_vm, (void **) &env, NULL);

    // release the references we hold

    if (objectRef != nil) {
        (*env)->DeleteGlobalRef(env,objectRef);
        objectRef = nil;        
    }
    if (byteFrameData != nil) {
        (*env)->DeleteGlobalRef(env,byteFrameData);
        byteFrameData = nil;        
    }
    if (shortFrameData != nil) {
        (*env)->DeleteGlobalRef(env,shortFrameData);
        shortFrameData = nil;       
    }
    if (intFrameData != nil) {
        (*env)->DeleteGlobalRef(env,intFrameData);
        intFrameData = nil;     
    }

    // Detatch from Java
    (*g_vm)->DetachCurrentThread (g_vm);

    g_vm = nil;

    [super dealloc];
}

@end