@RestControllerAdvice
public class WebRestControllerAdvice  {

    @ExceptionHandler(ExternalDependencyException.class)
    public String handleGitlabException(ExternalDependencyException ex, HttpServletResponse response) {
        try {
            response.sendError(460);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ex.getMessage();
    }
}