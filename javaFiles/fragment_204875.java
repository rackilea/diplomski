boolean hasMethod = false;
try { 
  Method m = value.getClass().getDeclaredMethod("byteCount", null); 
  hasMethod = true;
}
catch (NoSuchMethodException e) {
}
catch (SecurityException e) { 
  // you don't have access to the method from your package
}