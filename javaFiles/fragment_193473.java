public class ReturnResponse<ObjectType> {

    private ObjectType returnObj;
    private HttpStatus httpStatus;
    private String message;
    private String developerMessage;

    public ReturnResponse(ObjectType returnObj, /*other parameters...*/) {
        this.returnObj = returnObj;
        // set other parameters
    }

    public ObjectType getReturnObj() {
        return this.returnObj;
    }

    // ...
}