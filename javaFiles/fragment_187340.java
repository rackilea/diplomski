if(jEnv->ExceptionCheck() == JNI_TRUE ) {
  __android_log_write(ANDROID_LOG_DEBUG, "JNI", "HAS EXCEPTION"); 
  jthrowable exceptionObj = jEnv->ExceptionOccurred();

  jclass exceptionClass = cocos2d::JniHelper::getClassID("com/companyName/example/exceptions/MyException", jEnv);
  if (jEnv->IsInstanceOf(exceptionObj, exceptionClass)) {
    __android_log_write(ANDROID_LOG_DEBUG, "JNI", "Cought MyException!"); 

    throw MyException();
  }
}