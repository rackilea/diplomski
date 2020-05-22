Object o = pick("Hello", 123);       // 1

String s = pick("Hello", 123);       // 2
String s = pick("Hello", "world");   // 3

Integer i = pick("Hello", 123);      // 4
Integer i = pick(123, 456);          // 5
int i = pick(123, 456);              // 6