Call<List<ServerResponse>> call = retrofitInterface.showTheStations("http://api.gios.gov.pl/pjp-api/rest/station/findAll/");
        call.enqueue(new Callback<List<ServerResponse>>() {
            @Override
            public void onResponse(Call<List<ServerResponse>> call, Response<List<ServerResponse>> response) {
                Log.i(TAG, response.body().toString());

                List<ServerResponse> body = response.body();

                Log.i(TAG, body.get(0).getId()+"");
            }

            @Override
            public void onFailure(Call<List<ServerResponse>> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });