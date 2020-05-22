Integer i = new Integer(5);
Double d = new Double(13.3);
Number n;

 n = i; // widening conversion - OK
 n = d; // also widening conversion - OK

 i = (Integer) d;  // cannot cast from Double to Integer - ERROR

 // remember, current n = d (a Double type value)
 i = (Integer) n;  // narrowing conversion; appears OK, but will throw ClassCastException at runtime - ERROR