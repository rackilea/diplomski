@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundExceptionById extends RuntimeException {

    public EntityNotFoundExceptionById(String message) {
        super(message);
    }

}