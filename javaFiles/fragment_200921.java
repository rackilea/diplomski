call.enqueue(new Callback<Object>() {
   @Override
   public void onResponse(Call<Object> call, Response<Object> response) {
       response = response.body();
   }

  @Override
  public void onFailure(Call<Object> call, Throwable t) {

  }