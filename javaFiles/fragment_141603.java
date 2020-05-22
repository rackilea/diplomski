public Object reflectionDemo(String className, String getter) throws ClassNotFoundException, NoSuchMethodException {

   Object fieldValue;
   Class myClass = Class.forName(className);
   Object myClassInstance = myClass.newInstance(); //to get an instance of the class       

   if(myClassInstance instanceof My_Class_X123) {       
      //null because we are not specifying the kind of arguments that class takes
      Method getterMethod = myClass.getMethod(getter, null); 
      //null because the method takes no arguments
      //Also in the scenario that the method is static one, it is not necessary to pass in an instance, so in that case, the first parameter can be null.
      fieldValue = getterMethod.invoke(myClassInstance, null);
   } 

   return fieldValue;
}