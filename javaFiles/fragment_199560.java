jint JNICALL Java_foo_package_MyJavaClass_myNativeMethod(JNIEnv *jenv, jobject jobj)
{
    jclass clazz = (*jenv)->GetObjectClass(jenv, jobj);
    //  MyJavaClass method:  private void addData(byte[] data)
    jmethodID mid = (*jenv)->GetMethodID(jenv, clazz, "addData", "([B)V");
    assert(mid);

    const char buf[] = { 0, 1, 2, 3, 42 };
    const size_t buf_len = sizeof buf;

    jboolean isCopy;
    jbyte *jbuf = (*jenv)->GetByteArrayElements(jenv, buf, &isCopy);

    (*jenv)->CallVoidMethod(jenv, jobj, mid, jbuf);

    (*jenv)->ReleaseByteArrayElements(jenv, buf, jbuf, 0);

    return JNI_OK;
}