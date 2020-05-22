@Pointcut("within(aa.bb.*.rest..*)  && @within(org.springframework.web.bind.annotation.RestController)")
public void restControllers() {}

@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) " +
    "|| @annotation(org.springframework.web.bind.annotation.GetMapping)" +
    "|| @annotation(org.springframework.web.bind.annotation.PostMapping)" +
    "|| @annotation(org.springframework.web.bind.annotation.PathVariable)" +
    "|| @annotation(org.springframework.web.bind.annotation.PutMapping)" +
    "|| @annotation(org.springframework.web.bind.annotation.DeleteMapping)"
)
public void mappingAnnotations() {}

@Pointcut("execution(@(@org.springframework.web.bind.annotation.RequestMapping *) * *(..))")
public void requestMappingAnnotations() { }

@Before("restControllers() && requestMappingAnnotations()")
public void onExecute(JoinPoint jp) {}