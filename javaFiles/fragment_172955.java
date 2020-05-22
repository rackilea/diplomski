@Aspect
public class Interceptor {

    @Autowired
    IAutenticao autenticao;

    @Pointcut("execution (* br.com.sarhws.service.*.*(..))")
    private void service() {};

    @Pointcut("adviceexecution() && within(Interceptor)")
    private void myAdvice() {}

    @Before("service() && !cflow(myAdvice())")
    public void doAuthentication(JoinPoint jp) throws FaultException {

        /* this method is called several times */
        autenticao.verificarToken();
    }

}