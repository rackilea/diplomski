public Object methodExecutionMonitor(ProceedingJoinPoint pjp) throws Throwable {

       long startTime = System.nanoTime();
       Object retVal = pjp.proceed();
       long endTime = System.nanoTime();

       System.out.println("Method execution time (ns): " + pjp.getSignature() + " "
               + (endTime - startTime));

       return retVal;
   }