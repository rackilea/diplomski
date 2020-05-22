void receiveData(int n, siginfo_t *info,void* unused) {
//other code
JNIEnv* env = NULL;
    if(vm==NULL)
        return;
    (*vm)->AttachCurrentThread(vm,&env,0);
 jmethodID messageMe = (*env)->GetStaticMethodID(env,cl, "messageMe", "(Ljava/lang/String;)Ljava/lang/String;");
jobject result = (*env)->CallStaticObjectMethod(env,cl, messageMe, jstr);
}