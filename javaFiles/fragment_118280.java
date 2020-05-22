import java.lang.reflect.Field;
      class SimpleKeyPair {
         private String privateKey = "Cafe Babe"; // private field
      }
      public class PrivateMemberAccessTest {
        public static void main(String[] args) throws Exception {
          SimpleKeyPair keyPair = new SimpleKeyPair();
          Class c = keyPair.getClass();
          // get the reflected object 
          Field field = c.getDeclaredField("privateKey");
          // set accessible true 
          field.setAccessible(true);
          // prints "Cafe Babe"
          System.out.println("Value of privateKey: " + field.get(keyPair)); 
          // modify the member varaible
          field.set(keyPair, "Java Duke");
          // prints "Java Duke"
          System.out.println("Value of privateKey: " + field.get(keyPair)); 
        }
      }