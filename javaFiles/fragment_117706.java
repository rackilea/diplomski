%include "std_vector_pointer.i"

%typemap(javaout) S1* std::vector<S1*>::get {
  //custom code
}

struct S1 {};
std::vector<S1*> val;

%template(vector_s1) std::vector<S1*>;