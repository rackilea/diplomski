import java.lang.reflect.*;

public class NewInstance {
   static void print(String label, Object[] arr) {
      System.out.println(label);
      for (Object o : arr) {
         System.out.println(o);
      }
      System.out.println("---");
   }

   static Object newInstance(Object o) {
      Class<?> c = o.getClass();
      System.out.println("Class is " + c);
      print("FIELDS:", c.getDeclaredFields());
      print("METHODS:", c.getDeclaredMethods());
      print("CONSTRUCTORS:", c.getDeclaredConstructors());

      try {
         Constructor<?> cc = c.getDeclaredConstructor(c);
         o = cc.newInstance(o);
      } catch (NoSuchMethodException e) {
         System.out.println("No copy constructor found!");
      } catch (IllegalAccessException e) {
         System.out.println("Copy constructor inaccessible!");
      } catch (InstantiationException e) {
         System.out.println("Instantiation failed!");
      } catch (InvocationTargetException e) {
         System.out.println("Copy constructor threw " + e.getCause());
      }
      return o;
   }

   public static void main(String args[]) {
      Object o1 = "hello";
      Object o2 = newInstance(o1);
      boolean success = (o1 != o2) && (o1.equals(o2));
      System.out.println("Attempt " + (success ? "succeeded!" : "failed :("));
   }
}