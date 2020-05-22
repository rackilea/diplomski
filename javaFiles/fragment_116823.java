JNIEnv* AttachJava()
{
    JavaVMAttachArgs args = {JNI_VERSION_1_2, 0, 0};
    JNIEnv* java;
    jvm->AttachCurrentThread((void**) &java, &args);
    return java;
}