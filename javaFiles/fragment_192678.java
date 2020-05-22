@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SomethingNotFoundException extends APIException {
    public SomethingNotFoundException() {
        super(2, "Couldn't find something!");
    }
}