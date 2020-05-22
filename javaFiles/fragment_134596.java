%module example
%{
  #define SWIG_FILE_WITH_INIT
  #include "Source.h"
%}

%interface_impl(Space::Base1);

%include "Source.h"