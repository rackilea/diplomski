// Call 1
Call<Partners> call = apiService.getPartners();
call.enqueue(new Callback<Partners>() {
    @Override
    public void onResponse(Call<Partners> call, Response<Partners> response) {
        // Call 2, despite having a response 
        Call<Partners> call = apiService.getPartners();
        call.enqueue(new Callback<Partners>() {
            @Override
            public void onResponse(Call<Partners> call, Response<Partners> response) {