private <T extends TransferableData> String doSomething(List<T> data) {

  for(T object: data){
      object.invokeMethod();
  }
  //return the string according to your business logic.
}