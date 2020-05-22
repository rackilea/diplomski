myClass = null;
try {
  myClass = Class.forName(className);
  Field[] fields = myClass.getDeclaredFields();

  for(Field field : fields) {
    //do whatever with the field. Look at the API reference at http://java.sun.com/javase/6/docs/api/java/lang/reflect/Field.html    
  }
}

catch(Exception e) {
  //handle exception
}