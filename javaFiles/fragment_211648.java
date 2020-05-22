final class ErrorInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        Response.Builder responseBuilder = originalResponse.newBuilder();

        /* 
         * get body from response. caution! .string() cannot be called more 
         * than once, so a new response is built with the old response's body
         */
        String bodyString = originalResponse.body().string();

        // if response is an error: override response code to 400
        if (isError(bodyString)) {
            responseBuilder.code(400);
        }

        // clone response into new one
        responseBuilder.body(
            ResponseBody.create(originalResponse.body().contentType(),          
                                bodyString));

        return responseBuilder.build();
    }

    public boolean isError(String body) {
        Serializer ser = new Persister();

        try {
            return ser.validate(ErrorUtils.ApiError.class, body);
            // ser.validate() will throw if body can't be read into ApiError.class
        } catch (Exception e) {
            return false;
        }
    }
}

@Root(name="error")
public class ApiError {

    @Element
    private String message;

    @Element
    private String softver;

    public ApiError(@Element(name="message") String message, @Element(name="softver") String softver) {
        this.message = message;
        this.softver = softver;
    }

    public String getMessage() {
        return message;
    }

    public String getSoftver() {
        return softver;
    }
}