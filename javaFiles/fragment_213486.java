// These are actually ignored as far as the subsequent lines are concerned.
// The constructor will still be executed, but nothing is going to read the
// values of variables "a" and "b".
B a = new B();
B b = new B();

// Note this is the *type name*.
B.i = 10;
B.i = 5; 
System.out.println(B.i);