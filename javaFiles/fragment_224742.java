Method[] methods = stuffClass.getMethods(); 
for(Method m: methods) {
   if(m.getName().equals("doNiceStuff")) {
      Class<?> paramTypes = m.getParameterTypes();

      //condition on the desired parameter types comes here
      if(paramTypes.length==1 && A.class.isAssignableFrom(paramTypes[0]) {
        //we found it!
      }

   }
}