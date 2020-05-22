%typemap(in)        (char* pchInput, int inputSize) {
  $1 = JCALL1(GetDirectBufferAddress, jenv, $input); 
  $2 = (int)JCALL1(GetDirectBufferCapacity, jenv, $input); 
} 
%typemap(in)        (char* pchOutput, int* outputSize) {
  $1 = JCALL1(GetDirectBufferAddress, jenv, $input); 
  $2 = &((int)JCALL1(GetDirectBufferCapacity, jenv, $input)); 
} 

/* These 3 typemaps tell SWIG what JNI and Java types to use */ 
%typemap(jni)       (char* pchInput, int inputSize), (char* pchOutput, int* outputSize) "jobject" 
%typemap(jtype)     (char* pchInput, int inputSize), (char* pchOutput, int* outputSize) "java.nio.ByteBuffer" 
%typemap(jstype)    (char* pchInput, int inputSize), (char* pchOutput, int* outputSize) "java.nio.ByteBuffer" 
%typemap(javain)    (char* pchInput, int inputSize), (char* pchOutput, int* outputSize) "$javainput" 
%typemap(javaout)   (char* pchInput, int inputSize), (char* pchOutput, int* outputSize) { 
    return $jnicall; 
}