public <T> void callApi(T classz) {
    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    Call<T> apiList = apiService.getNewMatchListCallListCall(API_KEY);
    apiList.enqueue(new Callback<T>() {
        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            //T  T=response.body();


            Log.d("ApiCall", String.valueOf(response.body().getMatchList().get(0).getTeam1()));
            //  Log.d("ApiCall_22",T.getMatchList().get(0).getTeam1());
            Toast.makeText(getApplicationContext(), "inside", Toast.LENGTH_LONG).show();

            processResponse(response, classz);
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            Log.d("ApiCall_Error", t.toString());
        }
    });
}

private <T> void processResponse(Response<T> response, T classz) {
    if (classz instanceof OneModel) {
        processOneModelResponse(response);
    }
    if (classz instanceof AnotherModel) {
        processOAnotherModelResponse(response);
    }
}