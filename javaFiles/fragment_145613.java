public class ConstraintViolationException extends BaseApiRuntimeException {


  private static final long serialVersionUID = 1L;


  public ConstraintViolationException([module eg. enum of project modules] module, String resource) {
    super(module, resource);
  }

}