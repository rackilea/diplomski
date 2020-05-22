public <T> MyCustomObject get (Class<T>clz){
   List<SomeObjects> list= getList();

   for(SomeObject o : list){
      if (clz.isInstance(o)) {
          return (T) o;
      }
   }
}