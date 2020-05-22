ArrayAdapter<String> adapter;
 @Override
 public void onResponse(JSONArray response) {
    try {
         JSONObject jsonobj = response.getJSONObject(0);
         data = jsonobj.getString("Name");
         mylist.add(data);
         String[] nameData = new String[mylist.size()];
         nameData = mylist.toArray(nameData );
          adapter = new ArrayAdapter<String>  
            (MainActivity.this,android.R.layout.select_dialog_item,mylist);              
           AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);  
           actv.setThreshold(1);//will start working from first character  
           actv.setAdapter(adapter)
           Log.i("here", data);                               
           }                          
          catch (JSONException e) {                            
           e.printStackTrace();

            }
        }