int i = 13;     // this line does not create an object
Integer i2 = i; // at this line 13 is auto-boxed into an Integer object

char c = 'x';   // again: no object created:
List<Character> l = new ArrayList<Character>();
l.add(c);       // c is auto-boxed into a Character object