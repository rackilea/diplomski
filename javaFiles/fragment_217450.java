int a = 2; 
int b = 6;
int tmp = a; // now tmp has a value that is _copy_ of a i.e. 2
a = b;  // since we saved a in tmp, we can _mutate_ it, now a has b's value
b = tmp; // swap! here, b = a won't work because a contains b's current value.
// now a has value 6 and b has value 2, exactly what we wanted.