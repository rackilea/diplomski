@Override
public void onClick(View v) {

LoginModel loginModel = new LoginModel("user@example.com", "123");

RequestAPI service = RetrofitClient.getInstance().create(RequestAPI.class);

Call<ResponseBody> call = service.getResponse(loginModel.getEmail(), loginModel.getPassword());

call.enqueue(new Callback<ResponseBody>() {

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            Log.e("=====", response.body().string());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Log.e("=====", "error", t);
    }
});
}