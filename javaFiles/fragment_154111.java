public class Main {
    public static void main(String[] args) throws Exception {
        Provider provider = new Provider("prop");
        AbstractHolder obj = provider.create(DefaultHolder.class);
        System.out.println(obj.getProperty());
    }
}

public class Provider {
    private String property;

    public Provider(String property) {
        this.property = property;
    }

    public <T extends AbstractHolder> T create(Class<T> type) throws InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException, NoSuchMethodException {
        return type.getConstructor(property.getClass()).newInstance(property);
    }
}