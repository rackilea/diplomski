public class Singleton implements Serializable {
   private static final Singleton INSTANCE = new Singleton();

   public static Singleton getInstance(){
       return INSTANCE;
   }

   public Object readResolve() throws ObjectStreamException {
        return INSTANCE; //ensure singleton is returned upon deserialization.
   }
}