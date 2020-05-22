@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = NotFoundException.REASON)
class NotFoundException extends RuntimeException {
    static final String REASON = " not found"; // you can define this in another class

    public NotFoundException(String resourceName) {
        String something = resourceName + REASON;
    }
}