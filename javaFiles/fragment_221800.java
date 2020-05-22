protected void doInBackground(Void... params) {
    Log.i(TAG, "Doing background task");
    if(mTaskType==tTaskType.LOGIN_TASK){
        var loginFuture = ListenableFuture<UserDetail> login();

        Futures.addCallback(loginFuture, new FutureCallback<UserDetail>() {
            @Override
            public void onSuccess(UserDetail userDetail)
            {
                // do other stuff here that should be async
                // also optionally you could implement this as a transform
                // style thing to and return another future from this `doInBackground`
                // method so other parts of your code could know when it is completed.
            }

            @Override
            public void onFailure(Throwable exc) { 
                // I'd quite likely move the error handling from the login method here
                // as that way it can also handle any exceptions caused by the transform
                // from json to user detail as well. 
            }
        })
    }
} 

private ListenableFuture<UserDetail> login(){
    Log.i(TAG, "Doing login task...");
    ListenableFuture<JsonElement> loginFutureResult = mClient.invokeApi("login",    mJSONHelper.makeLoginObject(thisUser));
    Futures.addCallback(loginFutureResult, new FutureCallback<JsonElement>() {
        @Override
        public void onFailure(Throwable exc) {
            // This is just to keep with what your style is, for recording the error
            // I think you might be better off handling it at a higher level and
            // also you might want to check `exc` to see if it was an actual network
            // error and not for example just failed credentials or something.
            error.setError(ErrorHelper.Error.NETWORK_ERROR);
        }

        @Override
        public void onSuccess(JsonElement result) {
            Log.i(TAG, "The login was successful");
        }
    });

    // lets pretend that instead of returning the JSON response 
    // you wanted to map it to a user detail before returning, just to show how to do that.

    AsyncFunction<JsonElement, UserDetail> transformUserJsonFunction =
        new AsyncFunction<JsonElement, UserDetail>() {
            public ListenableFuture<UserDetail> apply(JsonElement userJson) {
                // some code to map the json element to user detail
                UserDetail userDetail = new UserDetail(userJson);
                return Futures.immediateFuture(userDetail);
            }
        };


    return Futures.transform(loginFutureResult, transformUserJsonFunction);
}