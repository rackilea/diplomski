public class SettingsClass {

    public static final boolean BOOT_TEST = true;
    public static final String BOOT_CLASS = "MyClass";
    public static final String BOOT_METHOD = "doMain";

}

public class MyClass {
    public static void doMain() {
    }
}

public class MainClass {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        if(SettingsClass.BOOT_TEST) {
            Class<?> clazz = Class.forName(SettingsClass.BOOT_CLASS);
            Method m = clazz.getMethod(SettingsClass.BOOT_METHOD);
            m.invoke(null);
            System.exit(1);
        }