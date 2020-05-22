// Thread 1 runs first
T1: v = true;
T1: System.out.println("n=" + n);  // prints n=false

// Thread 2 runs second
T2: n = true;
T2: System.out.println("v=" + v);  // prints v=true