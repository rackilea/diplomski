class MyContextHolder{
    ApplicationContext appContext;
    ......
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName)
    {
        return (T)appContext.getBean(beanName);
    }
}