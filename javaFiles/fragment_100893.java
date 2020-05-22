public class TimeMain extends AppCompatActivity {

TextView cityName;
ArrayList arrayList=new ArrayList<GetZones>();
Spinner mySpinner;

@TargetApi(Build.VERSION_CODES.N)
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_time_main);
    cityName=findViewById(R.id.cityName);

    mySpinner=(Spinner)findViewById(R.id.spinner);

    getCountryList();



    Time_Converter_Adapter adapter=new Time_Converter_Adapter(arrayList,this);

    mySpinner.setAdapter(adapter);

    mySpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            GetZones getZones;
            getZones= (GetZones) arrayList.get(i);
            cityName.setText(getZones.getCountryName());

        }


}




public void getCountryList()
{

    RequestQueue requestQueue;
    requestQueue = Volley.newRequestQueue(getApplicationContext());
    StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://api.timezonedb.com/v2/list-time-zone?key=Z35J0I51CRWE&format=json", new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            try {
                JSONObject res = new JSONObject(response);
                JSONArray jsonArray=res.getJSONArray("zones");
                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                    String countryName=jsonObject.getString("countryName");
                    int timestamp=jsonObject.getInt("timestamp");
                    String countryCode=jsonObject.getString("countryCode");
                    GetZones getZones=new GetZones(countryName,countryCode,timestamp);
                    arrayList.add(getZones);


                }


            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "There Was A Fatal Error!!!!", Toast.LENGTH_SHORT).show();
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Context context = getApplicationContext();

            if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                Toast.makeText(context,
                        "Connection Timed Out",
                        Toast.LENGTH_LONG).show();
            } else if (error instanceof AuthFailureError) {
                //TODO
            } else if (error instanceof ServerError) {
                //TODO
            } else if (error instanceof NetworkError) {
                //TODO
            } else if (error instanceof ParseError) {
                //TODO
            }
        }
    });
    requestQueue.add(stringRequest);
}