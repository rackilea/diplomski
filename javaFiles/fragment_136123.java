@Controller
public class MyController {

    public class MyException extends RuntimeException {
    };

    @RequestMapping("/testx")
    public void myMethod() {
        throw new MyException();

    }

    @ExceptionHandler(MyException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "blah")
    public void handler() {
        System.out.println("handler processed");
    }
}