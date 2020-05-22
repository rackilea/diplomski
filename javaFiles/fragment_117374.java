@Pointcut("within(com.xyz.someapp.trading..*)")
public void thePackagePointCut()

@Pointcut("execution(* get*(..))")
public void allGetters()

@Before("thePackagePointCut() && allGetters()")
public void applyAdvise(JoinPoint jp) {
    // Log before invocation

    // let the pointCut execute the method
}