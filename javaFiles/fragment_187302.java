BOOL WINAPI HandlerRoutine(__in DWORD dwCtrlType) {
    if (dwCtrlType == CTRL_CLOSE_EVENT) {
        JNIEnv *env;
        jint res =  jvm->AttachCurrentThread((void **)(&env), &env);
        jclass cls = env->FindClass("TestConsoleHandler");
        jmethodID mid = env->GetStaticMethodID(cls, "shutdown", "()V");
        env->CallStaticVoidMethod(cls, mid);
        jvm->DetachCurrentThread();
        return TRUE;
    }
    return FALSE;
}