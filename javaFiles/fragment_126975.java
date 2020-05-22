%module test

%{
#include "test.h"
%}

%include <cpointer.i>

%pointer_functions(struct context *,context_ptr);

%include "test.h"