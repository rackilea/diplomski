public class PlaceholderBean implements BeanNameAware, FactoryBean {

    public static Map<String, Object> beansByName = new HashMap<String, Object>();

    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public Object getObject() {
        return beansByName.get(beanName);
    }

    @Override
    public Class<?> getObjectType() {
        return beansByName.get(beanName).getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}