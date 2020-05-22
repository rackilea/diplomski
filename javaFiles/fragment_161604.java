@Override
protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
    super.customizeBeanFactory(beanFactory);
    String cacheBeanMetadataSysProp = System.getProperty(CACHE_BEAN_METADATA, "true");
    if (cacheBeanMetadataSysProp != null
        && cacheBeanMetadataSysProp.equalsIgnoreCase("false")) {
        beanFactory.setCacheBeanMetadata(false);
    } else if (cacheBeanMetadataSysProp != null
        && cacheBeanMetadataSysProp.equalsIgnoreCase("true")) {
        beanFactory.setCacheBeanMetadata(true);
    }
}