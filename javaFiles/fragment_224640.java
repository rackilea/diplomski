@Aspect
@EnableAspectJAutoProxy
public class SomeConfig {

    @Around(value = "@annotation(path.to.my.annotation.here)", argNames = "specificArg")
    public void doLogic(ProceedingJoinPoint joinPoint) throws Throwable {

        //create local variable X for thread execution here
        try{
            joinPoint.proceed(); //or joinPoint.proceed(Object[]);
        }
        finally {
        //use local variable X to do some logic
            VariableContext.setCurrentVariable("someValue");
            String result = VariableContext.getCurrentVariable();

        }
    }
}