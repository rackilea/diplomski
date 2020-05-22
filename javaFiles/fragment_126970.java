%module test

%{
#include "test.h"
%}

// These get called automatically, no need to expose:
%ignore init_context;
%ignore delete_context;

// Fake struct to convince SWIG it should be an object:
struct context {
  %extend {
    context() {
      // Constructor that gets called when this object is created from Java:
      struct context *ret = NULL;
      init_context(&ret); 
      return ret;
    }
    ~context() {
      release_context($self);
    }
  }
};

%include "test.h"