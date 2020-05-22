@Before("execution(* org.sec3.jpa.bean.*.deleteById(*)) && target(bean)")
public void getRepositoryName(JoinPoint jp , Object bean ) throws Exception {
    Advised advised = (Advised) bean;
    for(Class<?> clazz : advised.getProxiedInterfaces())
    System.out.println(clazz);
}