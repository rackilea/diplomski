// this can be called from native code, including in different .so files:
long multiply(int val1,int val2)
{
    long result;
    // ...compute result...
    return result;
}

// this can be called from Java via JNI:
JNIEXPORT jlong JNICALL Java_com_example_pdemo_MainActivity_multiply(JNIEnv *env, jobject obj, jint a, jint b)
{
     return multiply(a, b);
}