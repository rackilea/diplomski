public class LinksActivity extends AppCompatActivity 
  implements AdapterView.OnItemClickListener, Response.ErrorListener {

    private List<NewsItem> newsFeed = new ArrayList<>();
    private ArrayAdapter<NewsItem>  adapter;

    // Moved the Volley response to top-level
    private Response.Listener<JSONObject>  newsListener = new Response.Listener<JSONObject>()  {        

        @Override
        public void onResponse(JSONObject response) {
            try {
                JSONArray newsItems = response.getJSONArray("newsItems");

                for (int i = 0; i < newsItems.length(); i++) {
                    JSONObject temp = newsItems.getJSONObject(i);

                    String image = temp.getString("image");
                    String title = temp.getString("title");
                    String time = temp.getString("time");
                    String date = temp.getString("date");
                    String content = temp.getString("content");
                    String link = temp.getString("link");


                    newsFeed.add(new newsItem(title, content, date, time, link, image));
                }

                // Important!
                adapter.notifyDataSetChanged();

            } catch(JSONException e){
                Log.i("myTag", e.toString());
            }
        }
    };

    // This is Volley's error listener over the entire Activity
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.i("myTag", error.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        // Set and define the List and Adapter here
        ListView  newsItems = (ListView) findViewById(R.id.newsItems);
        newsItems.setOnItemClickListener(this);

        adapter = new CustomAdapter();
        newsItems.setAdapter(adapter);

        engine();
    }

    private void engine() {
        RequestQueue queue = Volley.newRequestQueue(this);

        // Now this method is much 'cleaner'
        JsonObjectRequest myReq = new JsonObjectRequest(Request.Method.GET,
                "http://10.0.2.2/news.json",
                null, 
                newsListener, this);

        myReq.setRetryPolicy(new DefaultRetryPolicy(
                30*1000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(myReq);
    }

    // The Activity itself handles the clicking
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NewsItem currentItem = newsFeed.get(position);
        Intent i = new Intent (Intent.ACTION_VIEW);
        i.setData(Uri.parse(currentItem.getUrl()));
        startActivity(i);
    }
}