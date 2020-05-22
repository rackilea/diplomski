import java.lang.reflect.Field;

public class Example {

    Integer f1;
    String f2;
    Example f3;

   public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
         Example obj = new Example();
         for (Field f : Example.class.getFields()) {
            f.set(obj,  f.getType().newInstance());
         }
   }
 }