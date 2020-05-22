Class[] signature = {String.class, Integer.class};
Method[] methods = someClass.getDeclaredMethods();

for ( Method m : methods ) {
  Class[] params = m.getParameterTypes();
  if ( params.length == signature.length ) {
    int i;
    for ( i = 0; i < signature.length && params[i].isAssignableFrom( signature[i] ); i++ ) {

    }
    if ( i == signature.length ) {
      System.out.println("Found matching method: " + m.getName());
    }
  }
}