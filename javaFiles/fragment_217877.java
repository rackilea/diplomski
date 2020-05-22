@Autowired
AplicationContext ctx;

...

Object bean = ctx.getBean(method.getDeclaringClass());