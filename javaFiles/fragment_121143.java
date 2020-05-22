class MyException extends Exception {

public int StatusCode;
public String StatusCodeDescription;
public String Request;
public String Response;

public MyException() {
}

public MyException(String msg) {
    super(msg);
}

public MyException(int statusCode, String statusCodeDescription,
        String request, String response) {
    StatusCode = statusCode;
    StatusCodeDescription = statusCodeDescription;
    Request = request;
    Response = response;
}

public int getStatusCode() {
    return StatusCode;
}

public void setStatusCode(int statusCode) {
    StatusCode = statusCode;
}

public String getStatusCodeDescription() {
    return StatusCodeDescription;
}

public void setStatusCodeDescription(String statusCodeDescription) {
    StatusCodeDescription = statusCodeDescription;
}

public String getRequest() {
    return Request;
}

public void setRequest(String request) {
    Request = request;
}

public String getResponse() {
    return Response;
}

public void setResponse(String response) {
    Response = response;
}