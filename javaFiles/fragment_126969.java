%module test

%{
#include "test.h"

// this code gets put in the generated C output from SWIG, but not wrapped:
static struct context *get_global_ctx() {
  static struct context *ctx = NULL;
  if (!ctx) 
    init_context(&ctx);
  return ctx;
}
%}

%typemap(in,numinputs=0) struct context *ctx "$1=get_global_ctx();"

%ignore init_context; // redundant since we call it automatically

%include "test.h"