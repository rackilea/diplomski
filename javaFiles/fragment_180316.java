@Override
public void onResponse(Call<List<Pandomats>> call, Response<List<Pandomats>> response) {
     pandomats.addAll(response.body());
     Log.v("ListPandomats", String.valueOf(pandomats.size()));

     for (int i = 0; i < pandomats.size(); i++) {
         Pandomats p = pandomats.get(i);

         Log.v("ListPandomats", p.getModel());   // prints model
         Log.v("ListPandomats", String.valueOf(p.getLatitude()));   // prints latitude
     }
}