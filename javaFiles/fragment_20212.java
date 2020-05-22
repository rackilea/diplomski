import java.lang.reflect.Field;

interface LoginPage {

    public static String UserName = "//input[@name='usertxt']";
}


public class Main {
    public static void main(String[] args) throws SecurityException, NoSuchFieldException, ClassNotFoundException,
        IllegalArgumentException, IllegalAccessException {
        String referenceName="LoginPage.UserName";
        String s[] = referenceName.split("\\.");
        final Field field = Class.forName(s[0]).getDeclaredField(s[1]);
        System.out.println(field.get(null));

    }
}