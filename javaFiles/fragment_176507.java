springContext
    .getAutowireCapableBeanFactory()
    .autowireBeanProperties(
        this,
        AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, 
        true
    );