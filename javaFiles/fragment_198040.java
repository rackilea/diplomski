%module test

%{
#include "test.hh"
#include <algorithm>
%}

%include <std_array.i>
%include <arrays_java.i>

%template(Vec3) std::array<double, 3>;

%extend std::array<double, 3> {
  std::array<double, 3>(double in[3]) {
    std::array<double, 3> temp;
    std::copy_n(in, 3, std::begin(temp));
    return new std::array<double, 3>(temp);
  }
}

%typemap(jstype) std::array<double, 3> "Coord"
%typemap(javain,pre="    Vec3 temp$javainput = new Vec3(new double[]{$javainput.x, $javainput.y, $javainput.z});",
         pgcppname="temp$javainput") std::array<double, 3>, const std::array<double, 3>& "$javaclassname.getCPtr(temp$javainput)"

%include "test.hh"