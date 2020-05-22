public class MyFactoryBean implements FactoryBean<MyClassInterface> {

    @Override
    public MyClassInterface getObject() throws Exception {
        return new MyClassImplementation();
    }

    @Override
    public Class<?> getObjectType() {
        return MyClassInterface.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}