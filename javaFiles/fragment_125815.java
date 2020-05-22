@Aspect
@Component
public class ControllerArgsValidator {
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restController() {
    }
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {
    }

    @Around("controller() || restController()")
    public Object validate(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        for (Object arg : args) {
            if (arg instanceof BaseRequestDTO) {
                if((BaseRequestDTO) arg).additionalData.isEmpty())
                    //do what ever;
            }
        }
        return point.proceed();
    }