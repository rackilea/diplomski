public void requestServerService(Callback<RequestAttributes> callback) {

    Call<RequestAttributes> call = new RetrofitConfig().getServiceRequester().requestRandomNumber();

    call.enqueue(callback);
}