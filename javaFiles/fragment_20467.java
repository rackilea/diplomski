void Java_keylogger_TestKeys_initializeJNIVars(JNIEnv *env, jobject obj) {
    jclass cls = (*env)->GetObjectClass(env,obj);
    callbackMethod = (*env)->GetMethodID(env, cls, "callBack", "(Ljava/lang/String;)V");
    callbackObject = (*env)->NewGlobalRef(env, obj);
    if(cls == NULL || callbackMethod == NULL) {
        printf("One of them is null \n");
    }
    called = TRUE;
}