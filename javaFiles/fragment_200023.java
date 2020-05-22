// Prints "true".
int i1 = 1;
Integer i2 = new Integer(i1);
System.out.println(i1 == i2);

// Prints "false".
int i1 = 0;
Integer i2 = new Integer(i1);
i1 += 1;
System.out.println(i1 == i2);