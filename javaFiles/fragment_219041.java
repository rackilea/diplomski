public class Snippet {

  @PropertyInfo(description = "test")
  public void testMethod() {
  }
  public static void main(String[] args)  {
    for (Method m : Snippet.class.getMethods()) {
      if (m.isAnnotationPresent(PropertyInfo.class)) {
        System.out.println("The method "+m.getName()+
        " has an annotation " + m.getAnnotation(PropertyInfo.class).description());
      }
    }
  }
}