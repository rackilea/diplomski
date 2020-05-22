public Object catchMethod(ProceedingJoinPoint point, SomeAnnotation someAnnotation) throws Throwable {        
    //some action
    try {
       Result result = point.proceed();
       //some action that are executed only if there is no exception
    }  catch (Exception e) {
       //some action that are executed only if there is an exception
       throw e; //!!
    } finally {
       //some action that is always executed
    }
 }