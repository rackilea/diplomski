@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidStateException extends APIException {
    public InvalidStateException() {
        super(1, "Application is in invalid state");
    }
}