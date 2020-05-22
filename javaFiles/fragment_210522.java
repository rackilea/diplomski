@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);



    dataSource = new MyContactDataSource(MainActivity.this); 
    dataSource.open();




    contactList = new ArrayList<HashMap<String,String>>();



    oflineContactList = dataSource.getContatcs();


    Log.i("data", oflineContactList.toString());
        ListView lv = getListView();

        ListAdapter adapter = new SimpleAdapter(
                MainActivity.this, oflineContactList,
                R.layout.list_item, new String[] { TAG_NAME, TAG_EMAIL,
                        TAG_PHONE_MOBILE }, new int[] { R.id.email,
                        R.id.name, R.id.mobile });

        setListAdapter(adapter);




    lv.setOnItemClickListener(new OnItemClickListener() {



        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                long arg3) {
            // getting values from selected ListItem
            String name = ((TextView) arg1.findViewById(R.id.name))
                    .getText().toString();
            String cost = ((TextView) arg1.findViewById(R.id.email))
                    .getText().toString();
            String description = ((TextView) arg1.findViewById(R.id.mobile))
                    .getText().toString();

            // Starting single contact activity
            Intent intent = new Intent(MainActivity.this, SingleListItemActivity.class);
            intent.putExtra(TAG_NAME, name);
            intent.putExtra(TAG_EMAIL, cost);
            intent.putExtra(TAG_PHONE_MOBILE, description);

            startActivity(intent);

        }
    });

    new GetContacts().execute();


}



private class GetContacts extends AsyncTask<Void, Void, Void>{

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Data is loading...please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
    }


    @Override
    protected Void doInBackground(Void... params) {
        // Creating service handler class instance
        ServiceHandler mHandler = new ServiceHandler();


        // Making a request to url and getting response
        String jsonStr = mHandler.makeServiceCall(url, ServiceHandler.GET);

         Log.d("Response: ", "> " + jsonStr);

         if(jsonStr != null){
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);

                //Getting JSON Array node
                contacts = jsonObject.getJSONArray(TAG_CONTACTS);

                // looping through All Contacts
                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject c = contacts.getJSONObject(i);

                    String id = c.getString(TAG_ID);
                    String name = c.getString(TAG_NAME);
                    String email = c.getString(TAG_EMAIL);
                    String address = c.getString(TAG_ADDRESS);
                    String gender = c.getString(TAG_GENDER);

                 // Phone node is JSON Object
                    JSONObject phone = c.getJSONObject(TAG_PHONE);
                    String mobile = phone.getString(TAG_PHONE_MOBILE);
                    String home = phone.getString(TAG_PHONE_HOME);
                    String office = phone.getString(TAG_PHONE_OFFICE);


                 // tmp hashmap for single contact
                    HashMap<String, String> contact = new HashMap<String, String>();

                 // adding each child node to HashMap key => value
                    contact.put(TAG_ID, id);
                    contact.put(TAG_NAME, name);
                    contact.put(TAG_EMAIL, email);
                    contact.put(TAG_PHONE_MOBILE, mobile);

                 // adding contact to contact list
                    contactList.add(contact);

                }
                dataSource.creareContacts(contactList);
                dataSource.close();
            } catch (JSONException e) {
                e.printStackTrace();
            }


         }
         else {
             Log.e("ServiceHandler", "Couldn't get any data from the url");
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void result) {

        super.onPostExecute(result);

        // Dismiss the progress dialog
        if(pDialog.isShowing()){
            pDialog.dismiss();
        }

         /**
         * Updating parsed JSON data into ListView
         * */
         ListAdapter adapter = new SimpleAdapter(
                 MainActivity.this, contactList,
                    R.layout.list_item, new String[] { TAG_NAME, TAG_EMAIL,
                            TAG_PHONE_MOBILE }, new int[] { R.id.name,
                            R.id.email, R.id.mobile });

         setListAdapter(adapter);
    }
}