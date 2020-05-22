void func(char* bytes, int numBytes)
{
    jclass callbackClass = fJNIEnv->GetObjectClass(fJObject);
    jmethodID javaFunc = fJNIEnv->GetMethodID(callbackClass, "javaFunc", "([B)V");

    jbyteArray array = fJNIEnv->NewByteArray(numBytes);
    fJNIEnv->SetByteArrayRegion(array, 0, numBytes, (jbyte *) bytes);

    fJNIEnv->CallNonvirtualVoidMethod(fJObject, callbackClass, javaFunc, array);
    fJNIEnv->DeleteLocalRef(array);
}