JNIEXPORT void JNICALL 
Java_compresor_app_tfg_compresor_MyNDK_compresion(JNIEnv* env, jobject , 
jcharArray jargv) {

  //jargv is a Java array of characters
  int argc = env->GetArrayLength(jargv);
  jchar *argv = new jchar[argc];
  env->GetCharArrayRegion(jargv, 0, argc, argv);