public abstract class AbstractBaseClass {

   public void publicMethod(){
       // ....
       String value = getAttribute();
       // ....
   }

   protected abstract String getAttribute();
}

public class ConcreteClass extends AbstractBaseClass {
    protected String getAttribute() {
      // Lazy loading attr
      if (attr==null) attr = "default value";
      return attr;
    }

    protected String attr;
}