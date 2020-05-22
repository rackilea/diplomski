Test.java:10: type parameter A is not within its bound
    public TesterClass<A, String> func2() {
                       ^
  where A,B are type-variables:
    A extends ParamedType<B> declared in class Test.TesterClass
    B extends Object declared in class Test.TesterClass
Test.java:11: type parameter A is not within its bound
        return new TesterClass<A, String>();
                               ^
  where A,B are type-variables:
    A extends ParamedType<B> declared in class Test.TesterClass
    B extends Object declared in class Test.TesterClass
2 errors