JNIEXPORT void JNICALL Java_testcli_stdErr
(JNIEnv *, jobject)
{
    perror(msg);
    exit(1);
}