class AppException extends Exception {
    public AppException(String msg) {
         super(msg);
    }
}

class UserNotFoundException extends AppException {
    public UserNotFoundException(String msg) {
         super(msg);
    }
}