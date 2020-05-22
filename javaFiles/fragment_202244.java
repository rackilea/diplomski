%module example
%include "arrays_java.i"

%apply signed char[ANY] { unsigned char[ANY] };

struct myStruct
{
   unsigned char data[1024];
   int len;
};