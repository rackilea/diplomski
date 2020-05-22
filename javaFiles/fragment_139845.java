for(Class<?> cl : classList){
   Mirror mirror = new Mirror().on(cl);
   for(Field f: mirror.reflectAll().fields()) {
      if(java.lang.reflect.Modifier.isStatic(f.getModifiers()) {
         writeln(mirror.get().field(f));
      }
   }
}