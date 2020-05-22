public class M {
  volatile int x;
  M(int v) { this.x = v; }
  int x() { return x; }
}

// thread 1
m = new M(42);

// thread 2
M lm;
while ((lm = m) == null); // wait for it
print(lm.x()); // allowed to print "0"