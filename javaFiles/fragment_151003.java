public class ReflectTest {

    public Collection<String> c;

    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println(Collection.class.getTypeParameters()[0]); // E
        System.out.println(Collection.class.getTypeParameters()[0] instanceof TypeVariable); // true
        System.out.println(Collection.class.getTypeParameters()[0] instanceof ParameterizedType); // false
        Field field = ReflectTest.class.getField("c");
        System.out.println(field.getGenericType()); // java.util.Collection<java.lang.String>
        System.out.println(field.getGenericType() instanceof TypeVariable); // false
        System.out.println(field.getGenericType() instanceof ParameterizedType); // true
    }

}