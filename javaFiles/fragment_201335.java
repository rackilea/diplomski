public void loadImageWithRetrofit(ImageView imageView) {
        final RetrofitImageLoader imageLoader = new RetrofitImageLoader(imageView);
        RemoteApi api = RemoteApi.Factory.create();

        api.getImage(ImageRequest.DEFAULT_BODY).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody body = response.body();
                if (response.isSuccessful() && body != null) {
                    imageLoader.execute(body.byteStream());
                } else {
                    Log.d(TAG, "Retrofit onResponse(): CODE = [" + response.code() + "], MESSAGE = [" + response.message() + "]");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "Retrofit onFailure(): t = [" + t + "]");
            }
        });
}