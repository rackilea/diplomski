public interface Foo{  
  public Object processA(Object first);
  public Object processB(Ojbect second);
}

public abstract class AbstractFoo implements Foo{
   protected AbstractFoo(){}

   public Object processA(Object o){
       // do stuff
       return null;
   }

   public Object processB(Object o){
       // do more stuff
       return null;
   }
 }

 public class ConcreteFoo extends AbstractFoo {
 }