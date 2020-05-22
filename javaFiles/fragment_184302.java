@Controller
public class MyController {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler({UnauthorizedException.class})
    public void handle() {
        // ...
    }
}