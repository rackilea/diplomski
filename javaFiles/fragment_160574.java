class UserNotFoundException extends Exception {

    public UserNotFoundException(Long id) {
        super(id);
    }

}