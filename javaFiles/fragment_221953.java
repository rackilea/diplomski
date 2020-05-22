jint_Java_com_stack_overflow_copyBytes(JNIEnv *e, jclass obj, jlong p)
{
    jclass thisClass = (*env)->GetObjectClass(e, obj);
    jfieldID sendId = (*env)->GetFieldID(e, thisClass, "sendBuffer", "[B");        
    jbyteArray bytes = (*e)->GetObjectField(e, obj, sendId)

    jbyte* b = (*e)->GetByteArrayElements(e, bytes, NULL);
    memcpy(myCBytes, b, len);
    (*e)->ReleaseByteArrayElements(e, bytes, b, 0);
}