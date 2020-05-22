Call<Language> call = myretro.getLanguage(obj);
// for asynchronous call
call.enqueue(new Callback<Language>() {

    @Override
    public void onResponse(Call<Language> call, Response<Language> response) {
        Log.d("response", "response");
    }

    @Override
    public void onFailure(Call<Language> call, Throwable t) {
        t.printstackTrace();

    }
});