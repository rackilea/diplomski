public class MyException extends Exception {
    private String errCode;

    public MyException(String errCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = errCode;
    }

    //getter, setter

}