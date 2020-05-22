public class WebApplicationException extends Exception implements Serializable
{
private static final long serialVersionUID = 1L;
private Response.Status status = Response.Status.BAD_REQUEST;

public WebApplicationException() {
    super();
}
public WebApplicationException(String msg) {
    super(msg);
}
public WebApplicationException(String msg, Exception e)  {
    super(msg, e);
}

public WebApplicationException(String msg, Response.Status status) {
    super(msg);
    this.status = status;
}
public WebApplicationException(String msg, Exception e, Response.Status status)  {
    super(msg, e);
    this.status = status;
}

public Response.Status getStatus() {
     return status;
}
}