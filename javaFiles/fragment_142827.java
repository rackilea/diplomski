public class NullFactoryBean implements FactoryBean<Void> {

    public Void getObject() throws Exception {
        return null;
    }

    public Class<? extends Void> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return true;
    }
}