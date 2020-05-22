private static MyJavaBeanClass = null;

public static MyJavaBeanClass getInstance(){
  if(null == instance){
    instance = new MyJavaBeanClass();
  }
  return instance;
}