class MyException extends Exception {
    ....
    public String getMessage() {
        return ExceptionHelper.getMessage(this);
    }
}

class MyRuntimeException extends RuntimeException {
    ....
    public String getMessage() {
        return ExceptionHelper.getMessage(this);
    }
}

class ExceptionHelper {
    public static String getMessage(Exception e) {
        // your shared impl here
    }
}