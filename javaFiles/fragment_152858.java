@ControllerAdvice(annotations = {UseAdviceA.class})
class AdviceA {

  @ExceptionHandler({SomeException.class})
  public ResponseEntity<String> handleSomeException(SomeException pe, HandlerMethod handlerMethod) {
    String value = handlerMethod.getMethod().getDeclaringClass().getAnnotation(UseAdviceA.class).myValue();
     //value will be ApiController
    return new ResponseEntity<>("SomeString", HttpStatus.BAD_REQUEST);
  }