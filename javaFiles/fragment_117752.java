service.getPopulationData(new Callback<JsonResponse> (){
    @Override
    public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
        Log.d("JSONData", response.body().toString());
        ArrayList<Worldpopulation> population=new ArrayList(response.body().getWorldpopulation());
    }

    @Override
    public void onFailure(Call<JsonResponse> call, Throwable t) {
        Log.d("JSONData", t.getMessage());
    }
});