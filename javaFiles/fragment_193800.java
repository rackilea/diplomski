class LoginScreen {
    ...
        new NetworkAccessClass(url, methodName, paramNames, paramValues,
            new ResponseHandler() {
                @Override
                void requestSucceeded(ResponseData responseData) {
                    LoginScreen.this.handleLoginSuccess(responseData);
                }
                @Override
                void requestFailed(ErrorCode errorCode) {
                    LoginScreen.this.handleLoginFailure(errorCode);
                }
    }
    ...
}