Retrofit retrofit = NetworkClient.getRetrofitClient(getApplicationContext());
UploadAPIs uploadAPIs = retrofit.create(UploadAPIs.class);

final retrofit2.Call call = uploadAPIs.uploadImage(hashMap);

call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("SICC", String.valueOf(call.request()));
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("FAIL", t.toString());
            }
        });