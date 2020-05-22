%module test

%typemap(javainterfaces) Foo "SomeInterface"
%typemap(javabase) Foo "SomeBase"

struct Foo {
};