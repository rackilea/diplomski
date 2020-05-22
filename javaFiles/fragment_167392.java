@Controller
public class ApiImpl {

    public String methodOne(...) {

    }

    @ExceptionHandler(ExceptionOne.class)
    public R exceptionTwo(ExceptionOne exe) {
      //set proper response code and return values
   }

   //other exceptions
  }