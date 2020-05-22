package com.billosuch.listviewblogpost;

    import java.util.ArrayList;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    import android.app.Activity;
    import android.os.Bundle;
    import android.util.Log;
    import android.widget.ListView;

    public class ListViewBlogPost extends Activity {

        // url to make request
        private static String url = "http://api.androidhive.info/contacts/";

        // JSON Node names
        private static final String TAG_CONTACTS = "contacts";
        private static final String TAG_ID = "id";
        private static final String TAG_NAME = "name";
        private static final String TAG_EMAIL = "email";
        private static final String TAG_ADDRESS = "address";
        private static final String TAG_GENDER = "gender";
        private static final String TAG_PHONE = "phone";
        private static final String TAG_PHONE_MOBILE = "mobile";
        private static final String TAG_PHONE_HOME = "home";
        private static final String TAG_PHONE_OFFICE = "office";
        final ListView lv1;
        ArrayList<SearchResults> searchResultss;

        // contacts JSONArray
        JSONArray contacts = null;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            searchResultss = new ArrayList<SearchResults>();
            lv1 = (ListView) findViewById(R.id.ListView01);

           new MyAsync(Youractivity.this).execute();

        }





    public class MyAsync extends AsyncTask<Void, Integer, Void> {



            public MyAsync(Activity activity) {
                this.activity = activity;


                context = activity;
                dialog = new ProgressDialog(context);


            }

            /** progress dialog to show user that the backup is processing. */
            private ProgressDialog dialog;
            /** application context. */
            private Activity activity;
            private Context context;



            protected void onPreExecute() {
                // TODO Auto-generated method stub
                super.onPreExecute();






            }

            @Override
            protected Void doInBackground(Void... params) {
                // TODO Auto-generated method stub


     JSONParser jparser = new JSONParser();
            JSONObject json = jparser.getJSONFromUrl(url);

            // looping through All Contacts

            Log.d("*********oSR", "B4 TRy");

            try {

                contacts = json.getJSONArray(TAG_CONTACTS);

                for (int i = 0; i < contacts.length(); i++) {

                    SearchResults oSR = new SearchResults();
                    JSONObject c = contacts.getJSONObject(i);

                    oSR.setId(c.getString(TAG_ID));
                    oSR.setName(c.getString(TAG_NAME));
                    oSR.setEmail(c.getString(TAG_EMAIL));
                    oSR.setAddress(c.getString(TAG_ADDRESS));
                    oSR.setGender(c.getString(TAG_GENDER));

                    JSONObject phone = c.getJSONObject(TAG_PHONE);

                    oSR.setPhone_mobile(phone.getString(TAG_PHONE_MOBILE));
                    oSR.setPhone_home(phone.getString(TAG_PHONE_HOME));
                    oSR.setPhone_office(phone.getString(TAG_PHONE_OFFICE));

                    searchResultss.add(oSR);

                    Log.d("*********oSR", oSR.getName());

                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            Log.d("*********oSR", "AFTER TRy");


                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                // TODO Auto-generated method stub
                super.onPostExecute(result);

                            lv1.setAdapter(new MyCustomBaseAdapter(this, searchResultss));



                             }



          }
    }