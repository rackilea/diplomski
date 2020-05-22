%module test

%{
#include "test.h"
%}

%typemap(jtype) (char *buf, int len) "byte[]"
%typemap(jstype) (char *buf, int len) "java.nio.ByteBuffer"
%typemap(jni) (char *buf, int len) "jbyteArray"
%typemap(javain,pre="    byte[] temp$javainput = new byte[$javainput.capacity()];"
                    "    $javainput.get(temp$javainput);")
        (char *buf, int len) "temp$javainput"

%typemap(in,numinputs=1) (char *buf, int len) {
  $1 = JCALL2(GetByteArrayElements, jenv, $input, NULL);
  $2 = JCALL1(GetArrayLength, jenv, $input);
}

%typemap(freearg) (const signed char *arr, size_t sz) {
  // Or use  0 instead of ABORT to keep changes if it was a copy
  JCALL3(ReleaseByteArrayElements, jenv, $input, $1, JNI_ABORT); 
}

%include "test.h"