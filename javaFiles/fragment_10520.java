Callback<List<CustomObject>> listener = new Callback<List<CustomObject>>() {

    @Override
    public void onResponse(Call<List<CustomObject>> call, Response<List<CustomObject>> response) {
        bar.setVisibility(GONE);
        recicleView.setVisibility(VISIBLE);
    }

    @Override
    public void onFailure(Call<List<CustomObject>> call, Throwable t) {
        bar.setVisibility(GONE);
        recicleView.setVisibility(VISIBLE);         
    }
};