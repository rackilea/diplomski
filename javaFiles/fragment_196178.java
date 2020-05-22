//DatapackerDLL.cpp
    JNIEXPORT void JNICALL Java__Observer_sendToClient
    (JNIEnv *, jclass, jobject)
    {
     DataPacker::sendToClient();
    }