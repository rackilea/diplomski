/*
    void *delegate;
    void *(*onSuccess)(void *);
    void *(*onError)(void *);
*/

    jlong jdelegate = (jlong)delegate;
    jlong jonSuccess = (jlong)onSuccess;
    jlong jonError = (jlong)onError;

    jclass class = (*env)->FindClass(env, "com/xxx/yyy/zzz");
    jmethodID method = (*env)->GetStaticMethodID(env, class, "signIn", "(JJJ)V");
    if (method)
        (*env)->CallStaticVoidMethod(env, class, method, jdelegate, jonSuccess, jonError);