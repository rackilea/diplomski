YourEndpoints request = retrofit.create(YourEndpoints.class);

Call<ResponseBody> yourResult = request.insertSetup(YourSetupBeanObject);
    yourResult.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            //response.code()
            //your string response response.body().string()
        }

        @Override
        public void onFailure(Throwable t) {
            //do what you have to do if it return a error
        }
    });