public ItemList loadList(OnDataLoaded onDataLoaded){

Call<ItemList> call = retrofitInit().loadList();

call.enqueue(new Callback<ItemList>() {
    @Override
    public void onResponse(Call<ItemList> call, Response<ItemList> response) {

        list = response.body();
       onDataLoaded.onDataLoaded(list);
        System.out.println(item.getItem().get(0).getName());
    }

    @Override
    public void onFailure(Call<ItemList> call, Throwable t) {
        System.out.println("FAILURE" + t.toString());
    }
});

return list; 

}