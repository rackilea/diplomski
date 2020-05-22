private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }