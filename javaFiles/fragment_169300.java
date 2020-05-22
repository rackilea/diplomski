JNIEXPORT void JNICALL Java_ClassName_MethodName
  (JNIEnv *env, jobject obj, jstring javaString)
{

    const char *nativeString = (*env)->GetStringUTFChars(env, javaString, 0);

    (*env)->ReleaseStringUTFChars(env, javaString, nativeString);
}