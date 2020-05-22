public interface Field {
}

...

public enum Fields implements Field {
  A_FIRST_FIELD,
  A_SECOND_FIELD
}

...

public class ParserException extends Exception {
  private final Field field;

  public ParserException(Field field) {
    this.field = field;
  }

  public Field getField() {
    return field;
  }
}