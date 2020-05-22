byte a = 1;
int b = 2;

a += b; // compiles
a = a + b; // doesn't compile as a byte + int = int
a = (byte) (a + b); // compiles as this is the same as +=