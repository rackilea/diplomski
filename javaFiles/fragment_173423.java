Call<Model2> call;
new RetroService().call(call, new RetroService.OnResponseListenerRetro<Model2>() {
    @Override
    public void onSuccess(String tag, Model2 response) {
        System.out.println(response);
    }

    @Override
    public void onError(String tag, RetroService.ErrorType error) {
        Toast.makeText(, "", Toast.LENGTH_SHORT).show();
    }
});