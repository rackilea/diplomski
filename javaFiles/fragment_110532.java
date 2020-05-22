class chargeExample extends AsyncTask<Void, Integer, ArrayList<Example>> {
    protected void onPreExecute(){
    }
    protected ArrayList<Example> doInBackground(Void... params) {
        ArrayList<Example> newList = new ArrayList<Example>();
        String url = "url of my GET method of my API REST";

        HttpGet method = new HttpGet(url);

        method.setHeader("content-type", "application/json");

        try{
            HttpResponse response = httpClient.execute(method);
            String responseString = EntityUtils.toString(response.getEntity());
            JSONArray responseJSON = new JSONArray(responseString);
            for(int i=0; i<responseJSON.length(); i++){
                JSONObject object = responseJSON.getJSONObject(i);

                int idMain = object.getInt("idMain");
                String date = object.getString("date");
                String name = object.getString("name");
                double value = object.getDouble("value");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
                Date datePar = sdf.parse(date);

                newList.add(new Example(idMain, datePar, name, value));
            }
        }catch(Exception ex){
            Log.e("ServicioRest", ex.toString());
        }
        return newList;
    }