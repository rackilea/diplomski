Class clazz = null;
 try{
  clazz = Class.forName("YourClass");
 } catch (ClassNotFoundException e){
  e.printStackTrace();
 }