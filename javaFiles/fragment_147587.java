package test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void reflectVulnerableMethod(String str) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
                    IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String[] parts = str.split("\\.");

        String forKlazz = "";
        for (int i=0; i<parts.length -1; i++) {
            if (i != 0){
                forKlazz += '.' + parts[i];
            }
            else forKlazz += parts[i];
        }
        Class<?> klazz = Class.forName(forKlazz);
        Method m = klazz.getMethod(parts[parts.length-1]);


        m.invoke(null);


    }

    public static void main(String[] args) {
        try {
            reflectVulnerableMethod("test.Example.testMethod");
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}