package test;

public class Test {

  public abstract class BaseClass {
    public void methodThatMightBeOverridden() {
    }
  }

  public class ConcreteClassWithOverriddenMethod extends BaseClass {
    @Override
    public void methodThatMightBeOverridden() {
      super.methodThatMightBeOverridden();
    }
  }

  public class ConcreteClassWithoutOverriddenMethod extends BaseClass {
  }

  public class AnotherConcreteClassWithoutOverriddenMethod extends ConcreteClassWithoutOverriddenMethod {
  }

}