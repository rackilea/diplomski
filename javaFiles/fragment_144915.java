JNIEXPORT jobject JNICALL ...init(JNIEnv * env, jobject obj)
  {
  FieldsHolder* myClass= new FieldsHolder();
  ... //prepare fields of the class
  return env->NewDirectByteBuffer(myClass, 0);
  }