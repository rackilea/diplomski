volatile int x = 0, y = 0;

// thread 1
x = 1;

// thread 2
y = 1;

// thread 3
if (x == 1) System.out.println(y);

// thread 4
if (y == 1) System.out.println(x);