import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice{

    @ExceptionHandler(value = UserException.class)
    public ModelAndView handleUserException(UserException ex){

        // Generate corresponding results(ModelAndView) based on exception.
        // example: Put the error message to model. 
        return new ModelAndView("prompt_page",ex.getMessage());
    }
}