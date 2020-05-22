public class ValidationErrorException extends Exception {

private List<String> errors;

public ValidationErrorException(List<String> errors) {
    super("Validation Errors.");
    setErrors(errors);
}

public ValidationErrorException(String message, List<String> errors) {
    super(message);
    setErrors(errors);
}

public void setErrors(List<String> errors) {
    this.errors = errors;
}

public List<String> getErrors() {
    return errors;
  }
 }