Field[] fields = controllerClass.getDeclaredFields();

for ( Field field : fields ) {
   field.setAccessible(true);
  System.out.println(field.get(someClass));

}