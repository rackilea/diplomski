JavaVM* vm;
    jsize vmCount;
    if (JNI_GetCreatedJavaVMs(&vm, 1, &vmCount) != JNI_OK || vmCount == 0) {
        fprintf(stderr, "Could not get active VM\n");
        return NULL;
    }

    JNIEnv* env;
    jint result = vm->GetEnv((void**)&env, JNI_VERSION_1_6);
    if (result == JNI_EDETACHED) {
        result = vm->AttachCurrentThread((void**)&env, NULL);
    }
    if (result != JNI_OK) {
        fprintf(stderr, "Failed to get JNIEnv\n");
        return NULL;
    }

    jclass cls = env->FindClass("JMyService");
    jmethodID ctor = env->GetMethodID(cls, "<init>", "()V");
    jobject service = env->NewObject(cls, ctor);

    jmethodID loadMethod = env->GetMethodID(cls, "loadContactInformation", "(I)Ljava/lang/String;");
    jobject serviceResult = env->CallObjectMethod(service, loadMethod, userId);
    return serviceResult;