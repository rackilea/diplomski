@Aspect
@Order(1)
@Component
public class UserAgentChangeAspect {

    @Pointcut("execution(public * *(..)) && @within(org.springframework.stereotype.Controller) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void preHandle()
            throws Exception {
        // logic
        }
    }

    @After("pointcut()")
    public void postHandle()
            throws Exception {
        // logic
    }
}