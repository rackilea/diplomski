// foo.h
class Foo {
private:
  int bar_;

public:
  int bar(); // getter
};

// foo.cpp
#include "foo.h"

int Foo::bar(){
  return bar_;
}