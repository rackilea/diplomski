public class GenericTypeReference<T> {

    private final Type type;

    protected GenericTypeReference() {
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        this.type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return this.type;
    }   

    public static void main(String[] args) {

        // This is necessary to create a Class<String> instance
        GenericTypeReference<Class<String>> tr =
            new GenericTypeReference<Class<String>>() {};

        // Retrieving the Class<String> instance
        Type c = tr.getType();

        System.out.println(c);
        System.out.println(getGenericType(c));

    }

    public static Type getGenericType(Type c) {
        return ((ParameterizedType) c).getActualTypeArguments()[0];
    }

}