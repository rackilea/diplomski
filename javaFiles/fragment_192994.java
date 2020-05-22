public List<?> list_values() throws Exception {
    String nome = classe().getSimpleName();
    Class<?> clazz = Class.forName("com.spring.model."+nome.toLowerCase()+"."+nome+"Service");
    Object object = clazz.newInstance();
    ApplicationContextHolder.getContext().getAutowireCapableBeanFactory().autowireBean(object);
    return (List<?>) object.getClass().getMethod("lista").invoke(object);
}