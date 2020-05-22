%module test

%{
#include "test.h"
%}

%include <std_string.i>

#define STRONG_TYPEDEF(o, n) struct n : o {};

%include "test.h"