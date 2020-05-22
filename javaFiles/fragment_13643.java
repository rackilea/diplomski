@EnableWebMvc
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ApplicationException.class})
    public void notFount(){
        System.out.println("----------CaughtApplicationException-----------");
    }

    @ExceptionHandler({Exception.class})
    public void notFountGlobal(){
        System.out.println("----------CaughtApplicationException-----------");
    }

}