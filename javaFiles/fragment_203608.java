HttpBinService service = retrofit.create(HttpBinService.class);
    Call<HttpBinService.Response> call = service.getIp();

    call.enqueue(new Callback<HttpBinService.Response>() {
        @Override
        public void onResponse(Call<HttpBinService.Response> call, Response<HttpBinService.Response> response) {

            if (response.isSuccessful()){
                Log.i("PROVARETROFIT", "OK");

//((TextView)findViewById(R.id.testo)).setText(res.body().getOrigin());
                System.out.println(response.body().getOrigin());
            } else {
                System.out.println("Unsuccesfull");
            }
        }

        @Override
        public void onFailure(Call<HttpBinService.Response> call, Throwable t) {
            System.out.println("Call failed");
        }
    });