%module test

%{
#include "test.h"
%}

%inline %{
  struct context* make_context() {
    struct context *ctx;
    init_context(&ctx);
    return ctx;
  }
%}

%ignore init_context;

%include "test.h"