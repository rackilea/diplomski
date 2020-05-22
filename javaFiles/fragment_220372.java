@Pointcut(value="execution(* com.company.app.features.*.controller.*.*(..))")
public void controller() { }

@Pointcut(value="execution(@within(org.springframework......GetMapping)")
public void getMapping() { }


@Before("controller() && getMapping(object)")
public void controllerGetMapping(Object objectIfYouNeedIt) {
    // Log
}