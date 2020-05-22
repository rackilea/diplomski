static double f(Integer x) { ... }
static double f(Double x) { ... }

// somewhere in the code:
Object h = new Double(14.0);
f(h); // won't compile - unable to determine which method you want to invoke
f((Integer)h); // will compile, but fail at run-time with ClassCastException
f((Double)h); // will compile and succeed.