interface Interface{
  public void someMethod();
}

public class A {
    int variable;

    Interface getA1() {
        return new Interface() {
            @Override
            public void someMethod() {
                variable++;
            }
        };
    }
}