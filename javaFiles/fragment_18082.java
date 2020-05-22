private void getCodes( Model_ApiCaller model_apiCaller) {
    MediaType mediaType = MediaType.parse("application/octet-stream");
    RequestBody body = RequestBody.create(mediaType, "{\"types\":\""+ model_apiCaller.getApiName()+"\"}");
    Call<List<ModelApiResponse>> call = null;
    call = RetroHelper.api.getApi("api_key",body);
    call.enqueue(new Callback<List<ModelApiResponse>>() {
        @Override
        public void onResponse(Call<List<ModelApiResponse>> call, Response<List<ModelApiResponse>> response) {
            try {
                tv_sample_data.setText( response.body().get(0).getApi());
            } catch (Exception e) {
                Log.d(TAG, "onResponse: "+e.toString());

            }
            Log.d(TAG, "onResponse: "+response.code());
        }

        @Override
        public void onFailure(Call<List<ModelApiResponse>> call, Throwable t) {
            tv_sample_data.setText("erererer!!!!");
        }
    });
}