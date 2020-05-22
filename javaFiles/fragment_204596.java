@Before("execution(* com.example.demo.classz.*.get*(..))")
    public void interceptRead(JoinPoint thisJoinPoint) {
        log.info(thisJoinPoint.toString());
    }

    @Before("execution(* com.example.demo.classz.*.set*(..)) && args(newValue)")
    public void interceptWrite(JoinPoint thisJoinPoint, Object newValue) {
        log.info(thisJoinPoint + " -> " + newValue);
    }