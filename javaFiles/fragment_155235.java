http://stackoverflow.com/questions/34848605/how-to-set-the-value-of-a-double-integer-type-of-a-java-class-by-jni

JNIEXPORT jint JNICALL test_jni_Native_testSet(JNIEnv *env, jclass type, jobject tdobj)
{
    //Create Integer class, get constructor and create Integer object
    jclass intClass = env->FindClass(env, "java/lang/Integer");
   jmethodID initInt = env->GetMethodID(env, intClass, "<init>", "(I)V");
    if (NULL == initInt) return -1;
    jobject newIntObj = env->NewObject(env, intClass, initInt, 123);

//Now set your integer into value atttribute. For this, I would
//recommend you to have a java setter and call it in the same way 
//as shown above

//clean reference
env->DeleteLocalRef(env, newIntObj); 
return 0;
}