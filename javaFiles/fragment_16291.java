JNIEXPORT void JNICALL Java_testcli_clearErr
  (JNIEnv *env, jobject jobj)

{
    errno = 0;
}