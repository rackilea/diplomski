String a="Hello";
String b1="He";
String b2="llo";
String b=b1+b2;

System.out.println(a==b); //prints false because b wasn't know to be "Hello" at compile time so could not use string pooling