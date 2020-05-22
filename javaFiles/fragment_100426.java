import java.lang.reflect.Method;

public class CustomStartup {

    private static final String NB_MAIN_CLASS = "org.netbeans.core.startup.Main";

    public static void main(String[] args) throws Exception {
        // do whatever you need here (e.g. show a custom login form)
        System.out.println("Hello world! I am a custom startup class");
        JWindow splash = initSplash();

        // once you're done with that, hand control back to NetBeans
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Class<?> mainClass = Class.forName(NB_MAIN_CLASS, true, classloader);

        Object mainObject = mainClass.newInstance();
        Method mainMethod = mainClass.getDeclaredMethod("main", new Class[]{String[].class});
        mainMethod.invoke(mainObject, (Object) args);

        splash.setVisible(false);
    }
}