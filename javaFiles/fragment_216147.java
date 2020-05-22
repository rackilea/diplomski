package de.scrum_master.aspect;

import org.aspectj.lang.SoftException;

import de.scrum_master.app.Transaction;

public aspect TransactionAspect {
  pointcut hasAnnotation(Transaction myAnnotation) : @annotation(myAnnotation);

  pointcut methodExecution() : execution(* *(..));

  Object around(Transaction myAnnotation) : methodExecution() && hasAnnotation(myAnnotation) {
    System.out.println(thisJoinPoint + " -> " + myAnnotation);
    boolean parameter = myAnnotation.myFlag();
    System.out.println("Transaction start");
    try {
      Object result = proceed(myAnnotation);
      System.out.println("Transaction commit\n");
      return result;
    } catch (Exception e) {
      System.out.println("Transaction roll-back\n");
      // Native AspectJ advices must not return checked exceptions, only runtime exceptions.
      // So we soften the caught exception, just in case.
      throw new SoftException(e);
    }
  }
}