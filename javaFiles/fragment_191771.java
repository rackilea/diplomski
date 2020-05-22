%module test
%include "std_function.i"

%std_function(Functor, void, int, double);

%{
#include <iostream>
%}

%inline %{
  std::function<void(int,double)> make_functor() {
    return [](int x, double y){
      std::cout << x << ", " << y << "\n";
    };
  }
%}