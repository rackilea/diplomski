%module test

%typemap(out) const SWIGTYPE&
{
  *($&1_ltype)&$result = new $1_basetype(($1_type)*$1);
}
%typemap(javaout) const SWIGTYPE&
{
  return new $javaclassname($jnicall, true);
}

%inline %{
struct A {
    int v;
    A() : v(0) {}
};

class B
{
public:
  B() { }
  const A& getA() const { return a_; }
  void counter() {
    a_.v++;
  }
  int test() const { return a_.v; }
private:
  A a_;
};

%}