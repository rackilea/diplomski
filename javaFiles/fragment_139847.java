for(Object obj : objectList){
   for(Field f: obj.getClass().getFields()) {
      if(!java.lang.reflect.Modifier.isStatic(f.getModifiers()) { //not 100% sure if this is required
         writeln(field(f.getName()).ofType(f.getType()).in(obj).get());
      }
   }
}