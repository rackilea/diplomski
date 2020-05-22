JNIEXPORT void JNICALL Java_EmojiTest_nativeTest(JNIEnv *env, jclass cls, jstring _s)
{
    const jclass stringClass = env->GetObjectClass(_s);
    const jmethodID getBytes = env->GetMethodID(stringClass, "getBytes", "(Ljava/lang/String;)[B");

    const jstring charsetName = env->NewStringUTF("UTF-8");
    const jbyteArray stringJbytes = (jbyteArray) env->CallObjectMethod(_s, getBytes, charsetName);
    env->DeleteLocalRef(charsetName);

    const jsize length = env->GetArrayLength(stringJbytes);
    const jbyte* pBytes = env->GetByteArrayElements(stringJbytes, NULL); 

    for (int i = 0; i < length; ++i)
        fprintf(stderr, "%d: %02x\n", i, pBytes[i]);

    env->ReleaseByteArrayElements(stringJbytes, pBytes, JNI_ABORT); 
    env->DeleteLocalRef(stringJbytes);
}