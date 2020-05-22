import java.util.*;
import java.lang.*;
import java.lang.reflect.*;

class A {
    public static String site1_URL = "http://url1.com";
    public static String site2_URL = "http://url2.com";
}

class B {

    public void setUrl(String alias, String value) throws IllegalAccessException {
        Field[] fields = A.class.getDeclaredFields();
        for(Field field : fields) {
            if(field.getName().equals(alias + "_URL")) {
                field.set(field, value);
            }
        }
    }

}

class Application {  
    public static void main(String args[]) throws IllegalAccessException {
        B b = new B();
        b.setUrl("site1", "a1"); // sets value
        b.setUrl("site2", "a2"); // sets value
        b.setUrl("site3", "a3"); // does nothing

        System.out.println(A.site1_URL); // prints a1
        System.out.println(A.site2_URL); // prints a2
    }
}