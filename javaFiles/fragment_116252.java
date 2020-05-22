public class JSONTask extends AsyncTask<String,String,String[]> {

    @Override
    protected String[] doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            //connecting to the url

            //Reading the data in bytes stream
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            // Reading the data by creating a buffer
            StringBuffer buffer = new StringBuffer();
            String line="";
            while((line = reader.readLine())!= null){
                buffer.append(line);
            }

            String finalJson = buffer.toString();
            JSONObject parentObject = new JSONObject(finalJson);

            List<String> list = new ArrayList<String>();
            JSONArray array = parentObject.getJSONArray("kitten");
            for(int i = 0 ; i < array.length() ; i++){
                list.add(array.getJSONObject(i).getString("if")+"\n");
            }
            return list.toArray(new String[list.size()]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally{
            if(connection !=null) {
                connection.disconnect();
            }

            try {
                if (reader != null)
                {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String[] result) {
        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, result);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Toast.makeText(MainActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
             }
        });

    }

}