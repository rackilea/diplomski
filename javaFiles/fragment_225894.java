public static <T> void programmaticInjection(Class<T> clazz, T injectionObject) throws NamingException {
    InitialContext initialContext = new InitialContext();
    Object lookup = initialContext.lookup("java:comp/BeanManager");
    BeanManager beanManager = (BeanManager) lookup;
    AnnotatedType<T> annotatedType = beanManager.createAnnotatedType(clazz);
    InjectionTarget<T> injectionTarget = beanManager.createInjectionTarget(annotatedType);
    CreationalContext<T> creationalContext = beanManager.createCreationalContext(null);
    injectionTarget.inject(injectionObject, creationalContext);
    creationalContext.release();
}