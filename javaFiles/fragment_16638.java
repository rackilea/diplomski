public enum ErrorCode {
    OK(0), KO(1);
    // ...
}

public class Error implements Serializable {
    private int code;
    private String message;
    // ...
}

public void myMethod() {
    // ...
    // something went bad!
    InternalError ie = getMyInternalErrorSomehow();
    Error error = new Error(ie.getErrorCode().getCode(), 
              "something bad happened and i am sending you a nice message");
    client.send(error);
}