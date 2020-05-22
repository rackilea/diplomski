Class1 class1=new Class1();
Method[] methods=class1.getClass().getDeclaredMethods();
for(Method i:methods){
   if (Modifier.isPublic(i.getModifiers())) {
     try {
       i.invoke(class1, "a");
     } catch (IllegalAccessException | InvocationTargetException e) {
       e.printStackTrace();
     }
  }
}