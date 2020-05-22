UserApi.Factory.getInstance().getUsers().enqueue(new Callback<List<User>>() {
        @Override
        public void onResponse(Response<List<User>> response, Retrofit retrofit) {
            for(User user: response.body()){
            Log.v("Endpoint Response: ", user.toString());
                textView_userid.setText(String.valueOf(user.getUserId()));
                textView_email.setText(user.getEmail());
                textView_firstname.setText(user.getFirstName());
                textView_lastname.setText(user.getLastName());
            }

        }

        @Override
        public void onFailure(Throwable t) {
            Log.e("failed", t.getMessage());

        }
    });


@GET("users")
Call<List<User>> getUsers();

class Factory{
    private static UserApi service;
    public static UserApi getInstance(){
        if(service == null){
            Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build();
            service = retrofit.create(UserApi.class);
            return service;
        }else{
            return service;
        }
    }
}