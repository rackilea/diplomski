SWIGEXPORT jlong JNICALL Java_impl_tools_CLJNI_Classifier_1init_1_1SWIG_11(JNIEnv *jenv, jclass jcls, jbyteArray jarg1) {
  jlong jresult = 0 ;
  signed char *arg1 = (signed char *) 0 ;
  size_t arg2 ;
  CL::Classifier *result = 0 ;

  (void)jenv;
  (void)jcls;
  {
    if (jarg1) {
      arg1 = (char *) jenv->GetByteArrayElements(jarg1, 0);     // ERROR HERE: invalid conversion from 'char*' to 'signed char*'
      arg2 = (size_t) jenv->GetArrayLength(jarg1);
    } else {
      arg1 = 0;
      arg2 = 0;
    }
  }
  result = (CL::Classifier *)CL::Classifier::init(arg1,arg2);
  *(CL::Classifier **)&jresult = result; 
  {
    if (jarg1) jenv->ReleaseByteArrayElements(jarg1, (jbyte *)arg1, 0);
  }

  return jresult;
}