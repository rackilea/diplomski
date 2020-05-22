%module test

%{
#include "test.h"
%}

%apply (char *STRING, size_t LENGTH) { (char *buf, int len) }
%typemap(javain) (char *buf, int len) "$javainput.array()"
%typemap(jstype) (char *buf, int len) "java.nio.ByteBuffer"

%include "test.h"