public class TestException extends Exception {

private static final long serialVersionUID = 1L;
private String code;
private String detailMessage;

public TestException() {
};

public TestException(String message, String code, String detailMessage) {
    super(message);
    this.code = code;
    this.detailMessage = detailMessage;
}

public TestException(String message, String code) {
    super(message);
    this.code = code;
}
//TestExceptionResponseCode is another class for message data, if required.
public TestException(TestExceptionResponseCode testExceptionResponseCode) {
    super(testExceptionResponseCode.getMessage());
    this.code = testExceptionResponseCode.getCode();
}

public String getCode() {
    return code;
}

public void setCode(String code) {
    this.code = code;
}

public String getDetailMessage() {
    return detailMessage;
}

public void setDetailMessage(String detailMessage) {
    this.detailMessage = detailMessage;
}