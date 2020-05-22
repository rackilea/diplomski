class A$Proxy extends A {

  MethodInterceptor interceptor;

  @Override
  void m1(){
    interceptor.intercept("m1");  
  }
}