%module test

%{
#include "test.hh"
%}

%include <std_array.i>
%template(Vec3) std::array<double, 3>;

%typemap(jstype) std::array<double, 3> "Coord"
%typemap(javain,pre="    Vec3 temp$javainput = new Vec3();\n"
                    "    temp$javainput.set(0, $javainput.x);\n"
                    "    temp$javainput.set(1, $javainput.y);\n"
                    "    temp$javainput.set(2, $javainput.z);",
         pgcppname="temp$javainput") std::array<double, 3>, const std::array<double, 3>& "$javaclassname.getCPtr(temp$javainput)"

%include "test.hh"