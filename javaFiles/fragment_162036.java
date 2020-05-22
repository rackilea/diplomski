if(map.get(key) == null){

  Object ret = map.putIfAbsent(key,value);
  if(ret == null){ // I won the put
     doSomethingElse();
  }
}