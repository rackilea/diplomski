public class Test1 extends AsyncTask<String, Void, String> {

protected String doInBackground(String... params) {
    try {
        //*OKHTTP ponoć parametry dodaje do buildera*
   //     RequestBody parametry = new FormBody.Builder()
    //            .add("offset", "0")
     //           .add("limit", "50")
      //          .build();

        OkHttpClient klient = new OkHttpClient();
         final Gson gson = new Gson();


       Request request = new Request.Builder()
                .url("http://www.apirest.poligon.webimpuls.pl/v1/restapi/aktualnosci?offset=0?limit=50")
               // .post(parametry)
               .build();



        Response response = klient.newCall(request).execute();
        return response.body().string();



    }catch (Exception e){



        return null;
    }



}


@Override
protected  void onPostExecute(String s){
    super.onPostExecute(s);

    List<ListItem> contentList = new ArrayList<>();
    /*
     her u need to read data from s to the list; 
     */

    MyListAdapter adapter = find();//here u need to get your Adapter, maybe its member of your fragment class
    adapter.setData(contentList);
}


}