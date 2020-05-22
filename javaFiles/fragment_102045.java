Class ContextAccessor{
    ApplicationContext context = new
        FileSystemXmlApplicationContext(this.getClass().getProtectionDomain().
        getCodeSource().getLocation().getPath());

    public static ApplicationContext getContext(){
        return context;
    }
}