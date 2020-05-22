public void checkguardadas(int id_usuario, OnOfertasResponse callback) {
    RetrofitService retrofitService = RetrofitService.getInstance();
    PabloAPI api = retrofitService.getApiProxyServer();
    Call<ArrayList<Oferta>> call = api.getGuardadas(1);

    call.enqueue(new Callback<ArrayList<Oferta>>() {
        @Override
        public void onResponse(Call<ArrayList<Oferta>> call, Response<ArrayList<Oferta>> response) {

            Log.d("traza", "por aqui");
            Log.d("traza", response.body().toString());

            // ejecutamos el callback
            callback.ofertas(response.body());
        }

        @Override
        public void onFailure(Call<ArrayList<Oferta>> call, Throwable t) {
            Log.d("traza", "por alla");
            Log.d("traza", t.toString());
        }
    }); 
}