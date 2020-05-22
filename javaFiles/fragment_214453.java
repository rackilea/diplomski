Call<ResponseBody> myCall = myApi.login(...)
myCall.enqueue(new Callback<ResponseBody>() {
    @Override
    public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
        // access response code with response.code()
        // access string of the response with response.body().string()
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
    }
});