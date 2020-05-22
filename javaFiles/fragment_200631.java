public class ObjectWrapper<T> {

    private T value;

    public ObjectWrapper (T value) {
        this.value = value;
    }

    //from http://stackoverflow.com/a/8019188/2958086
    public Class<T> getPersistentClass() {
        if (persistentClass == null) {
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return persistentClass;
    }
}