%module(directors="1") test
%include "std_function.i"

%std_function(Functor, void, int, double);

%{
#include <iostream>
void add_and_print(int a, double b) {
  std::cout << a+b << "\n";
}
%}

%callback("%s_cb");
void add_and_print(int a, double b);
%nocallback;

%inline %{
  std::function<void(int,double)> make_functor() {
    return [](int x, double y){
      std::cout << x << ", " << y << "\n";
    };
  }

  void do_things(std::function<void(int,double)> in) {
    in(-1,666.6);
  }
%}