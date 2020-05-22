String s1 = "dog";             // "dog" object from string pool
String s2 = new String("dog"); // new "dog" object on heap

System.out.println(s1 == s2);  // false

s2 = s2.intern();              // intern() returns the object from string pool

System.out.println(s1 == s2);  // true