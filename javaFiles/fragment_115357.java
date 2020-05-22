private void getPlacesResponse(String type) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface requestInteface = retrofit.create(RequestInterface.class);
        Call<Response> call = requestInteface.getPlacesJson(type, latitude + "," + longitude, proximityRadius);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(@NonNull  Call<Response> call, @NonNull Response<Resonse> response) {
              ArrayList<Result> dataList = response.body().getList();
             placeResultAdapter=new PlaceResultAdapter(MapActivity.this, dataList);
                      mRecyclerView.setAdapter(placeResultAdapter);
                }

            @Override
            public void onFailure(Response> call, Throwable t) {
                Log.d("error", call.toString() + "  " + t.toString());
            }
        });
    }