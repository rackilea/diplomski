// method of BeanPostProcessor
    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out.println(" POST PROCESS AFTER INITIALISATION ");
        return arg0;
    }

    // method of BeanPostProcessor
    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out.println(" POST PROCESS BEFORE INITIALISATION ");
        return arg0;
    }