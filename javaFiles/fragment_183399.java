enum TraceLevel { NONE, LEVEL1, LEVEL2, LEVEL3 }

@interface Trace {
  TraceLevel value() default TraceLevel.LEVEL1;
}

aspect X {
  // Advise all methods marked @Trace except those with a tracelevel of none
  before(): execution(@Trace !@Trace(TraceLevel.NONE) * *(..)) {
    System.err.println("tracing "+thisJoinPoint);
  }
}