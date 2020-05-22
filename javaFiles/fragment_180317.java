Service.getInstance()
    .getJSONApi()
    .loadList()
    .enqueue(new Callback<Pandomats>() {  /* remove List<> */

        @Override
        public void onResponse(Call<Pandomats> call, /* remove List<> */ Response<List<Pandomats>> response) {
            Pandomats p = response.body();

            // without for loop iteration you can get the data
            Log.v("ListPandomats", p.getModel());   // prints model
            Log.v("ListPandomats", String.valueOf(p.getLatitude()));   // prints latitude
        }

        @Override
        public void onFailure(Call<Pandomats> call, Throwable t) { /* remove List<> */
            Log.e("ListPandomats", "Error" t);
        }
    });