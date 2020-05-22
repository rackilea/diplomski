%module test

%{
#include "test.hh"
#include <algorithm>
%}

%include <arrays_java.i>

%apply double[3] { std::array<double, 3> };
%typemap(jstype) std::array<double, 3> "Coord"
%typemap(javain) std::array<double, 3>, const std::array<double, 3>& "new double[]{$javainput.x, $javainput.y, $javainput.z}"

%typemap(in) std::array<double, 3> //....

%include "test.hh"