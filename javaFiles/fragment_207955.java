%module test

%{
#include "test.h"
%}

// knows about things like int *OUTPUT:
%include "typemaps.i"
// knows about int32_t
%include "stdint.i"
// let's have an int32_t *OUTPUT for our int32_t *lenght
%apply int32_t *OUTPUT { int32_t *length }

%include "test.h"