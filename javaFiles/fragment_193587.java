JNIEXPORT void JNICALL Java_ClassName_MethodName(JNIEnv *env, jobject obj, jstring javaString)   
{
   const char *nativeString = env->GetStringUTFChars(javaString, 0);

   // use your string

   env->ReleaseStringUTFChars(javaString, nativeString);
}