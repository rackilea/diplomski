%module test

%{
#include "test.h"
%}

%include <std_string.i>

class SingleValue
{
public:
   SingleValue();
   ~SingleValue();
   std::string getValue() const;
};

struct RoadType : public SingleValue {
};

struct RoadSubType : public SingleValue {
};

struct FunctionalClass : public SingleValue {
};

RoadType make_road();
FunctionalClass make_func();