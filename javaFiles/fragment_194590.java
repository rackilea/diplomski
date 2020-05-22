// You didn't flesh out what an operator does or provides,
// so I'll just make something up.
interface Operator<T> {
  void apply(T arg);
}

// Request that a derived type provide its own type as a type
// parameter, per the Curiously Recurring Template Pattern (CRTP).
abstract class State<T extends State> {
  public void addOperator(Operator<? extends T> op) {
    final PrintStream s = System.out;
    s.print("Received an operator of concrete type ");
    s.print(op.getClass().getName());
    s.println('.');
  }
}

final class DerivedState extends State<DerivedState> {
}

public class Driver {
  public static void main(String[] args) {
    DerivedState ds = new DerivedState();
    ds.addOperator(new Operator<DerivedState>() {
      // ...
    });

    // And the following will not compile:
    ds.addOperator(new Operator<Integer>() { /* ... */ });
  }
}