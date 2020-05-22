public class SomeActivity extends AppCompatActivity {

    ProgressDialog pd;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_volley);

        txtView = (TextView) findViewById(R.id.txt_volley);

        String id = "bactiflox";
        String url = new Uri.Builder()
                .encodedPath("http://digitaresolutions.com")
                .appendEncodedPath("apps/drugindex/getbrand.php")
                .appendQueryParameter("id", id)
                .build().toString();

        JsonObjectRequest req = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                pd.dismiss();
                txtView.setText(response.toString());

                try {
                    JSONArray mydata = response.getJSONArray("mydata");
                    for (int i = 0; i < mydata.length(); i++) {
                        JSONObject obj = mydata.getJSONObject(i);

                        Log.i("JSON", obj.getString("manu"));
                        Log.i("JSON", obj.getString("details"));
                        Log.i("JSON", obj.getString("drugbrand"));
                    }
                } catch (JSONException e) {
                    txtView.setText(e.toString());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
                txtView.setText(String.valueOf(error));
            }
        });

        addToRequestQueue(req); // TODO: Implement
        pd = ProgressDialog.show(this,"Loading...","Please Wait...");

    }

}