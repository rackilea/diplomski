public class MethodCallRecognization {
  public static void main(String[] args) {
    MethodContainerC methodContainerC = new MethodContainerC();
    methodContainerC.display();
    // I want to know here
    String className=getClassName(methodContainerC.getClass(), "display") ;
    System.out.println(className);
  }
  public static String getClassName(Class c,String methodName){
       Method m[]=c.getDeclaredMethods();
       for(Method m1:m){
        if(m1.getName().equals(methodName)){
            return c.getName();
        }
       }
       return getClassName(c.getSuperclass(),methodName);

  }
}