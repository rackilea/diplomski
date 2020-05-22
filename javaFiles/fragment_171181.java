%module test

%include "vector.i"

%template(DblVec) std::vector<double>;
%template(ByteVec) std::vector<signed char>;
%include <std_string.i>
%template(StringVec) std::vector<std::string>;

%inline %{
struct foo {};
%}

%template(FooVec) std::vector<foo>;