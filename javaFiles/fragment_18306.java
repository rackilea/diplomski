public static String getClassname(Class c, String methodName){
 try{
  Method m= c.getDeclaredMethod( methodName);
  return c.getName();
}catch(NoSuchMethodException  nse){
   return getClassName(c.getSuperclass(),methodName);
}
}