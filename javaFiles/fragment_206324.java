public interface DoThings {
   void doThings() {}
   void doThings(String xx) {}
}

package classes;
public class One implements DoThings {
   public void doThings() {}
   public void doThings(String xx) {}
}

public static void main(String[] args){
    String className = "One"; //Imagine that it come from Voice-To-Text
    Class<?> clazz = Class.getDeclaredClass("classes." + className);
    DoThings instance = (DoThings) clazz.newInstance();
    instance.doThings();
    instance.doThings("String as argument");
}