%module test

%{
#include "test.hh"
%}

%include <std_array.i>
%template(Vec3) std::array<double, 3>;

%include "test.hh"