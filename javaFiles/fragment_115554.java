public interface InterfaceExposed{
      public void task();
} 

public class A{
     private class Implementation implements InterfaceExposed{
       public void task(){
             // some code to do task as per current implementation.
       }
     }
     public IExposedInterfaceOfA similarToEntrySet(){
          return new Implementation();
    }
}