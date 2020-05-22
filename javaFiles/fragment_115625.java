10 instanceof Integer // does not compile
Integer.class.isInstance(10) // returns true

Integer i = 10;
if (i instanceof String) // does NOT compile
if (String.class.isInstance(i)) // is false