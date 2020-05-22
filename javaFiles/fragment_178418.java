MyClient api = ServiceGenerator.createService(MyClient.class);
Call<MyItem> call = api.getMyItem(param1, param2, param3);
call.enqueue(new Callback<MyItem>() {
    @Override
    public void onResponse(Call<MyItem> call, Response<MyItem> response) {
        MyItem myItem=response.body();
    }

    @Override
    public void onFailure(Call<MyItem> call, Throwable t) {
        //Handle failure
    }
});