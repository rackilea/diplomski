// equal to question
long a = (long) ((int) ((char) (-2)));

//printing partial solutions
int number = -2;
char c = (char)number;
int i = (int)c;
long l = (long)i;

System.out.printf("number: %08x\n", number);
System.out.printf("char: %08x\n", (int)c); //cast to print
System.out.printf("int: %08x\n", i);
System.out.printf("long: %08x\n", l);