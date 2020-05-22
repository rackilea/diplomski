%module Classifier

%{
#include "Group.h"
#include "Classifier.h"
%}

%typemap(jtype) (signed char* modelMemory, const size_t modelMemorySize) "byte[]"
%typemap(jstype) (signed char* modelMemory, const size_t modelMemorySize) "byte[]"
%typemap(jni) (signed char* modelMemory, const size_t modelMemorySize) "jbyteArray"
%typemap(javain) (signed char* modelMemory, const size_t modelMemorySize) "$javainput"

%typemap(in,numinputs=1) (signed char* modelMemory, const size_t modelMemorySize) {
  $1 = JCALL2(GetByteArrayElements, jenv, $input, NULL);
  $2 = JCALL1(GetArrayLength, jenv, $input);
}

%typemap(freearg) (signed char* modelMemory, const size_t modelMemorySize) {
  // Or use  0 instead of ABORT to keep changes if it was a copy
  JCALL3(ReleaseByteArrayElements, jenv, $input, $1, JNI_ABORT);
}

%typemap(javadestruct, methodname="dispose", methodmodifiers="public synchronized") CL::Classifier {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      $jnicall;
    }
    swigCPtr = 0;
}

%typemap(javafinalize) CL::Classifier %{
    protected void finalize() {
      dispose();
    }
%}

%newobject CL::Classifier::init;

%include "Classifier.h"