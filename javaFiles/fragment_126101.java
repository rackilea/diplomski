JNIEXPORT void JNICALL
Java_sun_nio_ch_EPollArrayWrapper_interrupt(JNIEnv *env, jobject this, int fd)
{
    int fakebuf[1];
    fakebuf[0] = 1;
    if (write(fd, fakebuf, 1) < 0) {
        JNU_ThrowIOExceptionWithLastError(env,"write to interrupt fd failed");
    }
}