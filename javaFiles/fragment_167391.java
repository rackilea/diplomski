@ControllerAdvice
class MyProjectExceptionHandler {

   @ExceptionHandler(value = ExceptionOne.class)
   public R exceptionOne(ExceptionOne exe) {
      //set proper response code and return values
   }

   @ExceptionHandler(value = ExceptionTwo.class)
   public R exceptionTwo(ExceptionTwo exe) {
      //set proper response code and return values
   }
}