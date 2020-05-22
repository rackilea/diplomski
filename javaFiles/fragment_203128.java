%module example

%{
// code here is passed straight to example_wrap.c unmodified
#include "example.h"
%}

// code here is wrapped:
%include "example.h"