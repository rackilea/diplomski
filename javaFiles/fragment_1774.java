JNIEXPORT jint JNICALL Java_com_example_demojni_Sample_intMethod(JNIEnv* env, jobject obj,
    jint value) {
    return value * value;
}

JNIEXPORT jboolean JNICALL Java_com_example_demojni_Sample_booleanMethod(JNIEnv* env,
    jobject obj, jboolean unsignedChar) {
    return !unsignedChar;
}