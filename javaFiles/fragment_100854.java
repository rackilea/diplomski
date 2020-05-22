mQuery = mSearchTerm.getText().toString();
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/services/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Flicker> call = apiInterface.getImages(mQuery);

        call.enqueue(new Callback<Flicker>() {
            @Override
            public void onResponse(Call<Flicker> call, Response<Flicker> response) {
                Log.v("RESPONSE_CALLED", "ON_RESPONSE_CALLED");
                String didItWork = String.valueOf(response.isSuccessful());
                Log.v("SUCCESS?", didItWork);
                Log.v("RESPONSE_CODE", String.valueOf(response.code()));
                Flicker flicker_photos = response.body();
                Log.v("RESPONSE_BODY", "response:" + flicker_photos);
                String total = response.body().getPhotos().getTotal().toString();
                Log.v("Total", total);
                List<Photo> photoResults = response.body().getPhotos().getPhoto();
                for (Photo photo : photoResults) {
                    Log.v("PHOTO_URL:", photo.getTitle()
                    );
                }

            }

            @Override
            public void onFailure(Call<Flicker> call, Throwable t) {

            }
        });