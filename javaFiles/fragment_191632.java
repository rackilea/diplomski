public class StaticArgumentsTest {

    static Function<String, String> staticConsumer(String testValue) {
        return (st) -> testValue + " and " + st;
    }

    static final Function<String, String> aStaticConsumer =
            staticConsumer("Static String Example Value");

    public static void main(String[] args) {
        System.out.println(aStaticConsumer.apply("Dynamic String Example Value"));
        getCapturedValues(aStaticConsumer);
    }

    private static void getCapturedValues(Object instance) {
        Field[] f = instance.getClass().getDeclaredFields();
        AccessibleObject.setAccessible(f, true);
        for(Field field: f) {
            System.out.print(field.getName()+" ("+field.getType()+"): ");
            try { System.out.println(field.get(instance)); }
            catch(ReflectiveOperationException ex) { System.out.println(ex); }
        }
    }
}