private void gettingResponseFromRetrofit() {
            ApiInterface api = ApiClient.getWhatsNew().create(ApiInterface.class);
            Call<ResponseBody> call = api.getSupport_List("", 1, 10);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            // here you will get the response
                            // do your stuff
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Some Error Occur", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }