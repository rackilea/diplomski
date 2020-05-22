public class RestResponseExceptionMapper implements ResponseExceptionMapper<Exception> {

    public Exception fromResponse(Response r) {
        //throw you exception
        return new WebApplicationException(r.getStatus());
    }

}