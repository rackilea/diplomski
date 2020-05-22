JNINativeMethod methods[] = {
    {
        "frobFabulously",
        "(Ljava/lang/Object;)V",
        reinterpret_cast<void*>(NativeFrobFabulouslyImpl)
    },
};

env->RegisterNatives(clazz, methods, sizeof(methods)/sizeof(JNINativeMethod));