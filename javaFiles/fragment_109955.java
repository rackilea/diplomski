int x = 0, y = 0;

// thread 1
x = 1
if (y == 0) System.out.println("foo");

// thread 2
y = 1
if (x == 0) System.out.println("bar");