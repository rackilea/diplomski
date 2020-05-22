JNIEnv *env;
jvm->AttachCurrentThread((void **)&env, NULL);

//your code here

jvm->DetachCurrentThread();