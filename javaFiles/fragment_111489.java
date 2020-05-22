%module(directors="1") test

%{
#include <iostream>
#include "module.hh"
%}

%feature("director") Interface;
%include "std_string.i"

%include "module.hh"

%pragma(java) jniclasscode=%{
  static {
    try {
        System.loadLibrary("module");
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load. \n" + e);
      System.exit(1);
    }
  }
%}