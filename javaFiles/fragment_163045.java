call.clone().enqueue(new Callback<SlackApi.UploadFileResponse>() {
    @Override
    public void onResponse(Call<SlackApi.UploadFileResponse> call, Response<SlackApi.UploadFileResponse> response) {
        if (response != null) {
            Log.e("GAG", response.body().toString());
        }
    }

    @Override
    public void onFailure(Call<SlackApi.UploadFileResponse> call, Throwable t) {
        t.printStackTrace();
    }
});