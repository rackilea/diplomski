public Object validateNull(ProceedingJoinPoint pjp) {
  Object[] args = pjp.getArgs(); 
  for ( Object arg : args ) {
     //not null validation
  }
  pjp.proceed();
}