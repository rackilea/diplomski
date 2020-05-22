After that  you can call the own method.

Call<AgahiLastId> agahiLastIdCall = apiIinterface.getAgahiLastId();

agahiLastIdCall.enqueue(new Callback<AgahiLastId>() {
    @Override
    public void onResponse(Call<AgahiLastId> call, Response<AgahiLastId> response) {
        if (response.isSuccessful()) {
            Log.d("lts","ok");
        }
    }

    @Override
    public void onFailure(Call<AgahiLastId> call, Throwable t) {

    }
});}