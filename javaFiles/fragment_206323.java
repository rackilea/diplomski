package classes;
public class One {
   public void doThings() {}
   public void doThings(String xx) {}
}

public static void main(String[] args){
    String className = "One"; //Imagine that it come from Voice-To-Text
    Class<?> clazz = Class.getDeclaredClass("classes." + className);
    Method doThings = clazz.getDeclaredMethod("doThings");
    Method doThingsWithArgs = clazz.getDeclaredMethod("doThings", String.class);
    Object instance = clazz.newInstance();
    doThings.invoke(instance);
    doThingsWithArgs.invoke(instance, "String as argument");
}