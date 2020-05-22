@Override
 protected ArrayList<String> doInBackground(String... params) {


    try {

        HttpHandler httpHandler = new HttpHandler();
        Log.i("###URLFromAPI", "Entered");
        url = "http://13.71.112.116/?keyword=" + query; // This is the API call
        String jsonstr = httpHandler.makeServiceCall(url); //
        Log.i("###URLFromAPI", "Entered");
        JSONObject jsonObject = new JSONObject(jsonstr);
        urlOne = jsonObject.getString("urls"); // urls are being fetched and logged on the screen

        String[] urlArray = urlOne.split(","); //seperating the url
        list = new ArrayList<String>();

        for(int i=0;i<3;i++)
        {
            list.add(i,urlArray[i]);
            Log.i("###FROMLOOP",list.get(i));
        }

      runOnUiThread(new Runnable() {
            //String item;
            @Override
            public void run() {

                adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,list);
                Log.i("###","hello");
                listview.setAdapter(adapter);
                Log.i("###","hello");
                           });


       /* Log.i("###",urlOne);
        if (urlOne == "") {
            Log.i("###", "URL is null");
        }
        else
            Log.i("###URLFromAPI", urlOne.toString());*/
    }
    catch (Exception e){
        e.printStackTrace();
    }

    return list;
}