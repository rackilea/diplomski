for(Class<?> cl : classList){
    for(Field f : cl.getFields()){
      if(java.lang.reflect.Modifier.isStatic(f.getModifiers()) {
         writeln(field(f.getName()).ofType(f.getType()).in(cl).get());
      }
    }
}