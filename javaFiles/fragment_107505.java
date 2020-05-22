interface IValidator<T> {
  boolean validate(T field);
}

class SomeFieldOne<T> implements IValidator<T> {
  public boolean validate(T field) {
    print("SomeFieldOne validation");
    return true; // return true/false based on validation
  }
}

class SomeFieldTwo<T> implements IValidator<T> {
  public boolean validate(T field) {
    print("SomeFieldTwo validate");
    return true; // return true/false based on validation
  }
}

class Context {
  private IValidator validator;

  public Context(IValidator validator) {
    this.validator = validator;
  }

  public boolean validate(String field) {
    return this.validator.validate(field);
  }
}

public class TestValidation {
  public static void main(String[] args) {
    Context context;

    context = new Context(new SomeFieldOne());
    print(context.validate("some field one"));

    context = new Context(new SomeFieldTwo());
    print(context.validate("some field two"));

    // test other fields ....
    // .........
  }
}