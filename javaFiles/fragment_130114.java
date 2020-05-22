%module test

template<class T> class TSizedArray
{
public:
    int GetLength();
    T* GetElements() const;
};

%typemap(jstype) TSizedArray<long> "long[]"
%typemap(jtype) TSizedArray<long> "long[]"
%typemap(javaout) TSizedArray<long> {
    return $jnicall;
  }

%typemap(out) TSizedArray<long> {
  $result = JCALL1(NewLongArray, jenv, $1->GetLength());
  JCALL4(SetLongArrayRegion, jenv, $result, 0, $1->GetLength(), $1->GetElements());
}

class Producer
{
public:
    TSizedArray<long> GetLongs();
};