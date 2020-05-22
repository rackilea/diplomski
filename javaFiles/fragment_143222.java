ApiHelper.getService().stopPointsSet(request).enqueue(new Callback<serviceStopPoints>() {
            @Override
            public void onResponse(Call<serviceStopPoints> call, Response<serviceStopPoints> response) {
                //do with the response
            }

            @Override
            public void onFailure(Call<serviceStopPoints> call, Throwable t) {
               //error
            }
        });