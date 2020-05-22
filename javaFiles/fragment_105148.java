public enum Modes {ADDITION, SUBTRACTION, MULITPLICATION, DIVISION}

public interface Mode {
  double calculate(double a, double b);
}

public class AdditionMode implements Mode {
  public double calculate(double a, double b) {
    return (a+b);
  }
}
// similiar classes for other math operation modes

public class Calculator {
  private Mode mode;
  public setMode(Modes mode) {
    switch (mode) {
      case ADDITION: this.mode = new AdditionMode();
      // ...
    }
  }
  public double calculate(double a, double b) {
    return mode.calculate(a, b);
  }
}