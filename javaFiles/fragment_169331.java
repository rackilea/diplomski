void convertYUV( int width, int height, jbyteArray yuvArray ) {

     // Get the data from JEnv. 
    signed char *data = JNIEnvInfo::getInstance()->getJNIEnv()->GetByteArrayElements(yuvArray, 0);

     // Convert to Mat object.
     Mat imgbuf(Size(width,height), CV_8UC4, (unsigned char*) data);
     Mat img = imdecode(imgbuf, CV_LOAD_IMAGE_COLOR);

    //
    // Release the JNI data pointer.
    JNIEnvInfo::getInstance()->getJNIEnv()->ReleaseByteArrayElements(yuvArray, (jbyte*) yuvArray, 0);

    // ... do stuff with the Mat ..

}



Mat convertRGB(int width , int height , jintArray rgb8888)
{

    //
    int *rgb;
    int i;

    //
    // Get the data from JEnv. 
    int *data = JNIEnvInfo::getInstance()->getJNIEnv()->GetIntArrayElements(rgb8888, 0);

   //
   // Copy the data.
    for(i = 0; i < width * height; i++ ) {
        rgb[i] = data[i];
   }

   //
   // Convert to mat object.
   Mat imgbuf(Size(width,height), CV_8UC3, rgb);
   Mat img = imdecode(imgbuf, CV_LOAD_IMAGE_COLOR);

   //
   // Release the JNI data pointer.
   JNIEnvInfo::getInstance()->getJNIEnv()->ReleaseIntArrayElements(rgb8888, (jint*) rgb8888, 0);

   return img;
}