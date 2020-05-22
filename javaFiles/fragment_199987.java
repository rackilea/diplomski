public class C {
  int v;
  C(int v) { this.x = v; }
  int x() { return x; }    
}

public class M {
  volatile C c;
  M(int v) { this.c = new C(v); }
  int x() { 
    while (c == null); // wait!
    return c.x();
  }
}

// thread 1
m = new M(42);

// thread 2
M lm;
while ((lm = m) == null); // wait for it
print(lm.x()); // always prints "42"