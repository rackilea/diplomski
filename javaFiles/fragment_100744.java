public class APILogin {
    public void loginWithSuccessBlock(**final JsonHttpResponseHandler handler**) {
        HTTPClient httpClient = QHTTPClient.sharedHTTPClient;
        httpClient.get("/api/login", handler);
    }
}

public class LoginObject {
    public LoginObject {
        this.apiLogin.loginWithSuccessBlock(new JsonHttpResponseHandler(){
        ...
        );
    }
}