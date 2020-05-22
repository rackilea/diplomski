ApiService service = retroClient.getApiService();

    Call<Sample> call = service.CHECKIN(jsonStringer);

    call.enqueue(new Callback<Sample>() {
        @Override
        public void onResponse(Call<Sample> call, Response<Sample> response) {
            dialog.dismiss();
            if (response.isSuccessful()) {
                Sample result = response.body();


            } else {
                // response received but request not successful (like 400,401,403 etc)
                //Handle errors
            }

        }

        @Override
        public void onFailure(Call<Sample> call, Throwable t) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, "Network Problem", Toast.LENGTH_LONG).show();
        }

    });