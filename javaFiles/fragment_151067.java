public class Bean {

    private Class<?> clazz;

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClassName(String name) {
        try {
            this.clazz = Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Illegal class name.", e);
        }
    }

}