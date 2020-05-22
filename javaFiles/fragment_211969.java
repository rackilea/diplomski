inline jclass find_class_global(JNIEnv* env, const char *name){
    jclass c = env->FindClass(name);
    jclass c_global = 0;
    if (c){
        c_global = (jclass)env->NewGlobalRef(c);
        env->DeleteLocalRef(c);
    }
    return c_global;
}