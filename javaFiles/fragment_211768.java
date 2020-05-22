public class JSONAsyncTask extends AsyncTask<String, Void, Boolean>{

    @Override
    protected Boolean doInBackground(String... params) {
        HttpGet httpGs[0]);
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();
            if(status == 200){
                HttpEntity entity = response.getEntity();
                String data = EntityUtils.toString(entity);
                JSONArray jsonArray = new JSONArray(data);
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    Actors actor = new Actors();
                    actor.setName(object.getString("eventTitle"));

                    actorList.add(actor);   
                }
                return true;
            }

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {

        // tell the adapter that its data changed
        adapter.notifyDataSetChanged();
    }
}