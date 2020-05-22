public class ClassicSingleton {

   private static ClassicSingleton instance = null;
   public ArrayList<String> name = new ArrayList<String>(); // Member

   protected ClassicSingleton() {
      // Exists only to defeat instantiation.
   }
   public static ClassicSingleton getInstance() {
      if(instance == null) {
         instance = new ClassicSingleton();
      }
      return instance;
   }
   public String getName()
   {
   String myName="Chintan Khetiya";
   return myName;
   }

   public ArrayList<String> getNameformarray() {
     name.add("Android");
     name.add("IPhone");
     name.add("Windows");
     return name;

    }

}