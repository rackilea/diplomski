public <T extends Dog> List<T> getAll(Class<T> dogType){
  List<T> returnObjects = new ArrayList<>();

  for(Dog obj : dogList){ 
    if( dogType.isInstance(obj) ){ //as mentioned in the edit as well as the comments
        returnObjects.add(dogType.cast(obj));
    }
  }
  return returnObjects; 
}