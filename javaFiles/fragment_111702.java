public class MainActivity extends AppCompatActivity {

    RequestQueue queue;
    ListView listView;
    List<Hero> heroList;

    private String url="https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=d6eaad863cc640a7a6864d18196bea9e";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue= Volley.newRequestQueue(this);
        home();

        listView = (ListView) findViewById(R.id.listView);
        heroList = new ArrayList<>();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               /* Intent intent=new Intent(getApplicationContext(),ArticleActivity.class);
                intent.putExtra("description",url);
                startActivity(intent);*/
            }
        });
    }

    public void home()
    {
        JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject obj = new JSONObject(String.valueOf(response));

                    JSONArray array = obj.getJSONArray("articles");

                    for (int i = 0; i < array.length(); i++) {
                        Hero hero=new Hero( (String) array.getJSONObject(i).get("title"),(String) array.getJSONObject(i).get("urlToImage"));
                        Log.d("title ", String.valueOf(array.getJSONObject(i).get("title")));
                        Log.d("urlToImage ", String.valueOf(array.getJSONObject(i).get("urlToImage")));
                        heroList.add(hero);
                    }

                    ListViewAdapter adapter = new ListViewAdapter(heroList, getApplicationContext());
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}