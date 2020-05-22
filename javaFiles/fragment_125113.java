JNIEXPORT jint JNICALL Java_java_net_DualStackPlainSocketImpl_connect0
  (JNIEnv *env, jclass clazz, jint fd, jobject iaObj, jint port) 
{
    SOCKETADDRESS sa;
    ...
    rv = connect(fd, (struct sockaddr *)&sa, sa_len);