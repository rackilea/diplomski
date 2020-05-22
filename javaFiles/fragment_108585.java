static JavaVM *gJavaVM;
static jobject gCallbackObject = NULL;

JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    gJavaVM = vm;
    return JNI_VERSION_1_6;
}

JNIEXPORT void JNICALL JNI_FUNCTION(AndroidActivity_nativeInit)(JNIEnv* env, jobject obj, int width, int height) {
    // ...
    gCallbackObject = (*env)->NewGlobalRef(env, obj);
}

JNIEXPORT void JNICALL JNI_FUNCTION(AndroidActivity_nativeRelease)(JNIEnv* env, jobject obj) {
    (*env)->DeleteGlobalRef(env, gCallbackObject);
    gCallbackObject = NULL;
}

//this method is called from native code
void nativeSayHello(char* msg) {
    int status;
    JNIEnv *env;
    int isAttached = 0;

    if (!gCallbackObject) return;

    if ((status = (*gJavaVM)->GetEnv(gJavaVM, (void**)&env, JNI_VERSION_1_6)) < 0) {
        if ((status = (*gJavaVM)->AttachCurrentThread(gJavaVM, &env, NULL)) < 0) {
            return;
        }
        isAttached = 1;
    }

    jclass cls = (*env)->GetObjectClass(env, gCallbackObject);
    if (!cls) {
        if (isAttached) (*gJavaVM)->DetachCurrentThread(gJavaVM);
        return;
    }

    jmethodID method = (*env)->GetMethodID(env, cls, "SayHello", "(Ljava/lang/String;)V");
    if (!method) {
        if (isAttached) (*gJavaVM)->DetachCurrentThread(gJavaVM);
        return;
    }

    jstring string = (*mEnv)->NewStringUTF(mEnv, msg);
    (*env)->CallVoidMethod(env, gCallbackObject, method, string);

    if (isAttached) (*gJavaVM)->DetachCurrentThread(gJavaVM);
}