// Construct an environment with your client id and secret"
PayPalEnvironment environment = new PayPalEnvironment.Sandbox("xxxx","xxxx");

// Use this environment to construct a PayPalHttpClient
PayPalHttpClient client = new PayPalHttpClient(environment);

String refundId = "1234"; //set the refundId with the right value
String authorization = "xxxx" //The auth value would be Bearer <Access-Token> or Basic <client_id>:<secret>

// Construct a request object and set the desired parameters.
RefundsGetRequest request = new RefundsGetRequest(refundId)
                                 .authorization(authorization);

try {
    // Use your client to execute a request and get a response back
    HttpResponse<Refund> refundResponse = client.execute(request);

    // If the endpoint returns a body in its response, you can access the deserialized 
    // version by calling result() on the response.
    Refund refundDetails = refundResponse.result();
} catch (IOException ioe) {
    if (ioe instanceof HttpException) {
        // Something went wrong server-side
        HttpException he = (HttpException) ioe);
        int statusCode = he.getStatusCode();
        String debugId = he.getHeaders().header("PayPal-Debug-Id");
    } else {
        // Something went wrong client-side
    }
}