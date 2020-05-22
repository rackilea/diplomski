class MyAppException extends Exception {

private String message = null;

public MyAppException() {
    super();
}

public MyAppException(String message) {
    super(message);
    this.message = message;
}
}