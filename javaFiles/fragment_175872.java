// Thread 2 runs first
T2: n = true;
T2: System.out.println("v=" + v);  // prints v=false

// Thread 1 runs second
T1: v = true;
T1: System.out.println("n=" + n);  // may print n=true or n=false (depends on CPU caching)
                                   // will print n=true if n is volatile