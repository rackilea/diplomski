class ListHolder{

 private HashMap<Class<? extends BaseType>, List<? extends BaseType> hashListOfBaseType;

 //getter and setter for listOfBaseType
 public <T extends BaseType> List<T> getListOfBaseType(Class<T> clazz){
      return hashListOfBaseType.get(clazz);
 }

 public <T extends BaseType> void setListOfBaseType(Class<T> clazz, List<T> list){
      hashListOfBaseType.put(clazz, list);
 }

}