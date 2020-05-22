// Inside echoV
Object t = new Object();  // Note that this is NOT a String!
Object returnValue = t;
// In main
String stackTemp = (String) returnValue;  // This is the operation that fails
stackTemp.getClass();