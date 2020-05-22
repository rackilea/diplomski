public void loadUser(){
    call = api.getUser(email);
    call.enqueue(new Callback<List<User>>() {
        @Override
        public void onResponse(Call<List<User>> call, Response<List<User>> 
        response) {
            userDetails.postValue(response.body())
        }

        @Override
        public void onFailure(Call<List<User>> call, Throwable t) {
            Log.d("USER",t.getMessage());
        }
    });

  }