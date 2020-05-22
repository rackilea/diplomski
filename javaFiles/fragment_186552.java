serverService.contactServer(new Callback<RequestAttributes>() {
        @Override
        public void onResponse(Call<RequestAttributes> call, Response<RequestAttributes> response) {
            if (!response.isSuccessful()) {
                Log.i("Err", "Err: " + response.code());
            } else {
                RequestAttributes requestAttributes = response.body();
                String returnedValue = requestAttributes.getRandomNumber();
                // Do what you want here with returnedValue. You are in the activity thread(MainThread or UIThread) for example someTextView.setText(returnedValue);
                Log.d("jsonAnswer", "O numero aleatorio é: " + returnedValue);
            }
        }

        @Override
        public void onFailure(Call<RequestAttributes> call, Throwable t) {
            Log.e("Fail", "Failed: " + t.getMessage());
        }
    });