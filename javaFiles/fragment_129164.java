public class Foo implements Serializable
 {
   private String saveMe;
   private transient String dontSaveMe;
   private transient String password;
   //...
 }