Call<BaseModel> call;
new RetroService().call(call, new RetroService.OnResponseListenerRetro<BaseModel>() {
    @Override
    public void onSuccess(String tag, BaseModel response) {
        System.out.println(response);
    }

    @Override
    public void onError(String tag, RetroService.ErrorType error) {
        Toast.makeText(, "", Toast.LENGTH_SHORT).show();
    }
});