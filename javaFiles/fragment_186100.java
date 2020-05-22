public class MainActivity extends AppCompatActivity {

    String url = "http://114.35.246.42:2212/MobileApp/DEST_WebService.asmx/GetNews";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, jsonBody,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("TAG", response.toString());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("TAG", error.getMessage(), error);
                }
            }) { //no semicolon or coma
            @Override 
            public Map<String, String> getHeaders() throws AuthFailureError { 
                Map<String, String> params = new HashMap<String, String>();                
                params.put("Content-Type", "application/json");
                return params; 
            } 
        };
        mQueue.add(jsonObjectRequest);
    }
}