@Aspect
public class EncryptFieldAspect
{
    @Pointcut("call(@need.to.fully.qualify.Encrypt * *(java.lang.String)) && target(o) && args(inString) && !within(need.to.fully.qualify.EncryptFieldAspect)");
    void encryptStringMethod(Object o, String inString) {}

    @Around("encryptStringMethod(o,inString)")
    void myAdvice(Object o, String inString, ProceedingJoinPoint thisJoinPoint) {
        thisJoinPoint.proceed(new Object[]{o, FakeEncrypt.Encrypt(inString)});
    }
}