%module(directors="1") test

%{
#include <iostream>
#include "module.hh"
%}

%feature("director") Interface;
%include "std_string.i"

// (2.1)
%rename(NativeInterface) Interface; 

// (2.2)
%typemap(jstype) const Interface& "Interface";

// (2.3)
%typemap(javainterfaces) Interface "Interface"

// (2.5)
%typemap(javain,pgcppname="n",
         pre="    NativeInterface n = makeNative($javainput);")
        const Interface&  "NativeInterface.getCPtr(n)"

%include "module.hh"

%pragma(java) modulecode=%{
  // (2.4)
  private static class NativeInterfaceProxy extends NativeInterface {
    private Interface delegate;
    public NativeInterfaceProxy(Interface i) {
      delegate = i;
    }

    public String foo() {
      return delegate.foo();
    }
  }

  // (2.5)
  private static NativeInterface makeNative(Interface i) {
    if (i instanceof NativeInterface) {
      // If it already *is* a NativeInterface don't bother wrapping it again
      return (NativeInterface)i;
    }
    return new NativeInterfaceProxy(i);
  }
%}