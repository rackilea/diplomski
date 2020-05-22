@ControllerAdvice
public class GlobalBindingInitializer {

 /* global InitBinder  */

 @InitBinder
 public void binder(WebDataBinder binder) {
  binder.registerCustomEditor(Double.class, new CustomDoubleEditor());
 }
}