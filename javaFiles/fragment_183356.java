public <T> void method(Object obj, Class<T> objClass) {
  if(objClass.isInstance(obj)) {
    T t = objClass.cast(obj);
    //do something with t instead of obj
  }
}