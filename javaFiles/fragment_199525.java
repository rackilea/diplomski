JNIEXPORT jstring JNICALL Java_com_example_service_signal_hello
(JNIEnv * env, jobject obj) {
(*env)->GetJavaVM(env,&vm);
ob = (*env)->NewGlobalRef(env,obj);
jclass clazz = (*env)->FindClass(env,"com/example/service/signal");
cl = (*env)->NewGlobalRef(env,clazz);
}