@Slf4j
@RestController
@ControllerAdvice
public class ExceptionController implements ErrorController {

  // @ExceptionHandler methods here.

  @Override
  public String getErrorPath() {
    return null;
  }
}