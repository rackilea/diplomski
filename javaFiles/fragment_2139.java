@Controller
public class BaseController {

    @ExceptionHandler (Exception.class)
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleAllExceptions(Exception ex) {
        return new JsonError(ex.getMessage()).asModelAndView();
    }

    @ExceptionHandler (InvalidArticleQueryRangeException.class)
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public ModelAndView handleAllExceptions(InvalidArticleQueryRangeException ex) {
        return new JsonError(ex.getMessage()).asModelAndView();
    }
}