bool testTwoObjectEqual(JNIEnv *env, jobject jobj1, jobject jobj2) {
    jclass cls1 = env->GetObjectClass(jobj1);
    jclass cls2 = env->GetObjectClass(jobj2);
    bool res = env->IsInstanceOf(jobj1, cls2) && env->IsInstanceOf(jobj2, cls1);
    env->FreeLocalRef(cls1);
    env->FreeLocalRef(cls2);
    return res;
}