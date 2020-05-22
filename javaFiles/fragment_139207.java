jclass thread = (*env)->FindClass(env, "java/lang/Thread");
jmethodID mCurThread = (*env)->GetStaticMethodID(env, thread, "currentThread", "()Ljava/lang/Thread;");
jmethodID mIsInterrupted = (*env)->GetMethodID(env, thread, "isInterrupted", "()Z");
jobject curThread = (jobject)(*env)->CallStaticObjectMethod(env, thread, mCurThread);

for (;;) {
    // do some stuff
    jboolean res = (jboolean)(*env)->CallBooleanMethod(env, curThread, mIsInterrupted);
    if (res == JNI_TRUE) {
        LOGI("INTERRUPTED");
    } else {
        LOGI("WORKING");
    }
}