jintArray ret = CallStaticFunction("arrayFunc", buf, 3);
int *p = env->GetIntArrayElements(ret, NULL);
for(int i=0;i<3;++i){
    printf("%d\n", p[i]);
}
env->ReleaseIntArrayElements(ret, p, JNI_ABORT);