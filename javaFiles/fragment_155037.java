%module test

%{
#include "test.h"
%}

%include "test.h"

%extend Animal {
  Killable *toKillable() {
    return dynamic_cast<Killable*>($self);
  }
}