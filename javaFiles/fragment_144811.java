%module test

%typemap(javabody,noblock=1) SWIGTYPE {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected $javaclassname(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected $javaclassname(long cPtr, boolean cMemoryOwn, Object cParent) {
    this(cPtr, cMemoryOwn);
    swigCParent = cParent;
  }

  protected static long getCPtr($javaclassname obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  private Object swigCParent;
}

%typemap(javaout) SWIGTYPE const & {
    return new $javaclassname($jnicall, $owner, this);
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