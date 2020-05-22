public class ClassObjectFromString {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("RandomPrograms.ABC");
        Constructor<?> ctor = clazz.getConstructor(String.class);
        Object object = ctor.newInstance(new Object[] { "Message" });
    }