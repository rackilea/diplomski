JNIEXPORT void JNICALL Java_ConsoleIO_printList(JNIEnv *env, jclass cls, jobject obj)
{

    jclass listClass = (*env)->GetObjectClass(env,obj);

    jmethodID sizeMethod = (*env)->(env,listClass,"size","()I");
    jmethodID getMethod = (*env)->GetMethodID(env,listClass,"get","(I)Ljava/lang/Object");

    jint size =  (*env)->CallIntMethod(env,sizeMethod);


}