public void sendPost(MultipartBody.Part txt) {
mAPIService.savePost(txt).enqueue(new Callback<Void>() {
    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {

        if(response.isSuccessful()) {
            Log.i("TAG", "post submitted to API." + response.body().toString());
        }
    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {
        Log.e("TAG", "Unable to submit post to API.");
    }
});
}