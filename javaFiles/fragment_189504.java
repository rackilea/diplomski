%module Classifier

%{
#include "Group.h"
#include "Classifier.h"
%}

%apply(char *STRING, size_t LENGTH) { (signed char *modelMemory, size_t modelMemorySize) };

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