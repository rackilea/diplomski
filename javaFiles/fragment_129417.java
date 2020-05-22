@Around("execution(* MyClass.myMethod())")
  public void doSth(ProceedingJoinPoint joinpoint) throws Throwable {

     boolean invokeMethod = false; //Should be result of some computation
     if(invokeMethod)
     {
         joinpoint.proceed();
     }
     else
     {
         System.out.println("My method was not invoked");
     }
  }