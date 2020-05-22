// knows about things like int *OUTPUT:
%include "typemaps.i"
// knows about int32_t
%include "stdint.i"
%include "arrays_java.i"
%apply int[] {int *};

// convert char * to byte array
%apply signed char[] {char* pchar}; 

%include "wchar.i"