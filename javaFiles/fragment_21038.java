%module(directors="1") c_backend

%{
#include "c_backend.h"
%}

%typemap(jstype) (double *DOUBLE, size_t LENGTH) "double[]"
%typemap(jtype) (double *DOUBLE, size_t LENGTH) "double[]"
%typemap(jni) (double *DOUBLE, size_t LENGTH) "jdoubleArray"
%typemap(javadirectorin) (double *DOUBLE, size_t LENGTH) "$jniinput"
%typemap(javain) (double *DOUBLE, size_t LENGTH) "$javainput"
%typemap(in,numinputs=1) (double *DOUBLE, size_t LENGTH) {
  // Note the NULL here if you don't want to be making changes visible
  $1 = JCALL2(GetDoubleArrayElements, jenv, $input, NULL);
  $2 = JCALL1(GetArrayLength, jenv, $input);
}
%typemap(freearg) (double *DOUBLE, size_t LENGTH) {
  // Swap 0 for JNI_ABORT if you don't want to make changes visible
  JCALL3(ReleaseDoubleArrayElements, jenv, $input, $1, 0); 
}
%typemap(directorin,descriptor="[D") (double *DOUBLE, size_t LENGTH) { 
  $input = JCALL1(NewDoubleArray, jenv, $2); 
  JCALL4(SetDoubleArrayRegion, jenv, $input, 0, $2, $1); 
} 
%typemap(directorargout) (double *DOUBLE, size_t LENGTH) {
  (jenv)->GetDoubleArrayRegion($input, 0, $2, $1); 
} 

%feature("director") CallbackHandler;

%apply (double *DOUBLE, size_t LENGTH) { (double *params, size_t size) };

%include "c_backend.h"