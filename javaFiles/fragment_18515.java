public static void main(String... args) {
  // do this - declare the variable to be of type Set, which is an interface
  Set buddies = new LinkedHashSet();  // <- change the constructor call

  // don't do this - you declare the variable to have a fixed type
  // this you have to change both the variable type and the constructor call
  // HashSet buddies2 = new HashSet();  // old version
  LinkedHashSet buddies2 = new LinkedHashSet();
 }