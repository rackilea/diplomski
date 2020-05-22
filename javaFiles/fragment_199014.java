@Pointcut("execution(public * *(..))") //this should work for the public pointcut
private void anyPublicOperation() {}

//@Pointcut("@annotation(Service)") this might still work, but try 'within' instead
@Pointcut("@within(Service)") //this should work for the annotation service pointcut
private void inTrading() {}

@Pointcut("anyPublicOperation() && inTrading()")
private void tradingOperation() {}