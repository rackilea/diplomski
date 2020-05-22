public class UglyAdapter<T> extends ArrayAdapter<T>{

  public void doTypeSpecificStuff(T obj){
    Class<T> objectClass = obj.getClass();
    if(objectClass.equals(Integer.class)){
      Integer intObj = (Integer) obj;
      // here you can call Integer-specific methods
    }else if(objectClass.equals(String.class)){
      String strObj = (String) obj;
      // here you can call String-specific methods
    }
    else if(objectClass.equals(Word.class)){
      Word wordObj = (Word) obj;
      // here you can call Word-specific methods
    }
    else{
      // object is unsupported type. Throw exception or do whatever
    }
  }

}