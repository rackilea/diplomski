static char framebuf[100];

JNIEXPORT void JNICALL Java_javaapplication45_UseByteBuffer_readBuf
  (JNIEnv *env, jobject usebb, jobject bb) {
    void *addr = env->GetDirectBufferAddress(bb);
    framebuf[0] = 77;
    memcpy(addr,framebuf,100);
}