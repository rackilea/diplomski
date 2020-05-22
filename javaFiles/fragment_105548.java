jstring Java_it_stefanocappa_ndkexample_Example_stringFromJNI( JNIEnv* env, jobject thiz ) {    
    jclass clazz = (*env)->GetObjectClass(env, thiz);        
    jmethodID staticMethodId1;
    staticMethodId1 = (*env)->GetStaticMethodID(env, clazz, "getCurrValue", "()J");
    jlong staticMethodResult2;
    staticMethodResult2 = (jlong) (*env)->CallStaticLongMethod(env, clazz, staticMethodId1);
    return (*env)->NewStringUTF(env, "Hello from JNI);
}