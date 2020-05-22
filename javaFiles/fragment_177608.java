%module example
%{ 
#include "example.h"
%}
%typemap(jni) Buffer "jbyteArray"
%typemap(jtype) Buffer "byte[]"
%typemap(jstype) Buffer "byte[]"
%typemap(in) Buffer {
    $1.addr = (unsigned char *) JCALL2(GetByteArrayElements, jenv, $input, 0);
    $1.size = JCALL1(GetArrayLength, jenv, $input);
}
%typemap(argout) Buffer {
    JCALL3(ReleaseByteArrayElements, jenv, $input, (jbyte *) $1.addr, 0);
}
%typemap(out) Buffer {
    $result = JCALL1(NewByteArray, jenv, $1.size);
    JCALL4(SetByteArrayRegion, jenv, $result, 0, $1.size, (jbyte *) $1.addr);
    delete[] $1.addr;
}
%typemap(javain) Buffer "$javainput"
%typemap(javaout) Buffer { return $jnicall; }
%ignore Buffer;
%include "example.h"