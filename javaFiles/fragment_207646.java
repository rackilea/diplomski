jmethodID classifierConstructor = env->GetMethodID(cls,"<init>", "()V"); 
if (classifierConstructor == NULL) {
  return NULL; /* exception thrown */
}

jobject classifierObj = env->NewObject( cls, classifierConstructor);