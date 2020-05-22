SearchAPI api = retrofit.create(SearchAPI.class);
    api.getSearchData(lat,log,miles).enqueue(new Callback<SearchData>() {
        @Override
        public void onResponse(Call<SearchData> call, Response<SearchData> response) {
            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(Call<SearchData> call, Throwable t) {
            Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            System.out.println("Anshul : "+t.getMessage());
        }
    });