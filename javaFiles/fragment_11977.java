public class CustomGenericAllException extends RuntimeException {


    private String errorCode;
    private String errorMsg;

   //getter and setter for errorCode and errorMsg       

    public CustomGenericAllException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}