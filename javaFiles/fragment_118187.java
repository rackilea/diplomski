class objectA
{
    jobject dataMutex;
    ... // everything else mentioned before
}

// called on c++ thread
void objectA :: poll()
{
    // You will need to aquire jniEnv pointer somehow just as usual for JNI
    jniEnv->MonitorEnter(dataMutex);

    ... // all the poll stuff from before

    jniEnv->MonitorExit(dataMutex);
}

// called on java thread
void objectA :: supplyData(JNIEnv* jni, jobject jthis, jobject data)
{
    // You will need to aquire jniEnv pointer somehow just as usual for JNI
    jniEnv->MonitorEnter(dataMutex);

    ... // all the supplyData stuff from before

    jniEnv->MonitorExit(dataMutex);
}