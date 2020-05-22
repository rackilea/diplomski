JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *jvm, void *reserved) {
    JNIEnv *env = 0;

    if ((*jvm)->GetEnv(jvm, (void**)&env, JNI_VERSION_1_4)) {
        return JNI_ERR;
    }

    javaVM = jvm;

    return JNI_VERSION_1_4;
}