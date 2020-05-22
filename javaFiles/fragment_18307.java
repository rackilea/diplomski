public class MethodCallRecognization {
      public static void main(String[] args) {
        MethodContainerC methodContainerC = new MethodContainerC();
        methodContainerC.display("" , "");//Suppose it takes String id and String name parameter 
        // I want to know here
         Class[] parametertype={String.class,String.class};
        String className=getClassName(methodContainerC.getClass(), "display", parametertype) ;
        System.out.println(className);
      }
      public static String getClassname(Class c, String methodName, Class[] parametertype){
        try{
           Method m= c.getDeclaredMethod( methodName, parametertype);
           return c.getName();
        }catch(NoSuchMethodException  nse){
          return getClassName(c.getSuperclass(),methodName, parametertype);
       }
      }
    }