JsonPlaceholderApi  jsonPlaceholderApi  = retrofit.create(JsonPlaceholderApi.class);
    Call<Boolean> call = jsonPlaceholderApi.sign("userName", "password");
    call.enqueue(new Callback<Boolean>() {
        @Override
        public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            if (!response.isSuccessful()){
                Log.e("Response","Something went wrong."+response.toString());
                return;
            }

            Log.d("Response",response.toString());

        }

        @Override
        public void onFailure(Call<Boolean> call, Throwable t) {
            Log.e("Response",t.getMessage());
        }
    });