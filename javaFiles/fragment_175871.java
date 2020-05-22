// They run in parallel, so assignments first, in any order
T1: v = true;
T2: n = true;

// Print statements second, in any order
T1: System.out.println("n=" + n);  // may print n=true or n=false (depends on CPU caching)
                                   // will print n=true if n is volatile
T2: System.out.println("v=" + v);  // prints v=true