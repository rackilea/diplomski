public class EnumSetEditor<T extends Enum<T>> extends Composite implements LeafValueEditor<Set<T>>, HasEditorErrors<Set<T>> {

  //Added errorHandler attribute
  private SideErrorHandler errorHandler;

  public EnumSetEditor(Class<T> clazz) {

    ...
    //Initialize the ErrorHandler
    this.errorHandler = new SideErrorHandler(this);
  }

  /* 
   * Implemented showErrors(List<EditorError> errors)
   * I only delegate the errors to the ErrorHandler.
   */

  @Override
  public void showErrors(List<EditorError> errors) {
    if(errors.isEmpty()) {
      errorHandler.clearInvalid();
    } else {
      errorHandler.markInvalid(errors);
    }
  }
}