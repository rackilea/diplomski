// Creates the string "123", add it to the intern pool and assign "123" to s
String s = "123";  

// s.intern() returns the intern string of s. Because s is already the 
// string "123" present in the intern pool s and s.intern() are the same
System.out.println(s == s.intern());// true 

// "123" is already in intern pool. new String("123") create a new String
// that equals "123" but it is a different object
String s2 = new String("123"); 

// It prints false because s2 is equals to "123", but not the same object
// because a new String was created in the preciding row
System.out.println(s2 == s);// false

// It prints true because s2.intern() returns the string present in the
// intern pool that is equals to s2. That string exists and is "123"
System.out.println(s2.intern() == s);  // true