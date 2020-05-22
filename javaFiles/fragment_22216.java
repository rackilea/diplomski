call.enqueue(new Callback<UserResult>() {
    @Override
    public void onResponse(@NonNull Call<UserResult> call, @NonNull Response<UserResult> response) {
        if (response.isSuccesfull()) {
            UserResult result = response.body();
            //use the value result.isSet where you need it
        } else {
            //something is broken
        }
    }

    @Override
    public void onFailure(@NonNull Call<UserResult> call, @NonNull Throwable t) {

        Toast.makeText(MainActivity.this, "no ", Toast.LENGTH_SHORT).show();
    }
});