// Type mismatch: cannot convert from Object to String
Object o = "Ha!";
String s = o; // DOESN'T COMPILE

// Compiles fine, cast succeeds at run-time
Object o = "Ha!";
String s = (String) o;

// Compiles fine, throws ClassCastException at run-time
Object o = Boolean.FALSE;
String s = (String) o;