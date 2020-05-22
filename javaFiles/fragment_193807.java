public class HomeFragment extends Fragment {

private static final String TAG = HomeFragment.class.getSimpleName();
private ListView listView;
private FeedListAdapter listAdapter;
private List<FeedItem> feedItems;
private String URL_FEED = "http://example.com/feed.json";

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.home_fragment, container, false);
    listView = (ListView) view.findViewById(R.id.list);

    feedItems = new ArrayList<>();

    listAdapter = new FeedListAdapter(getActivity(), feedItems);
    listView.setAdapter(listAdapter);

    Cache cache = AppController.getInstance().getRequestQueue().getCache();
    Entry entry = cache.get(URL_FEED);
    if (entry != null) {
        try {
            String data = new String(entry.data, "UTF-8");
            try {
                parseJsonFeed(new JSONObject(data));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    } else {
        JsonObjectRequest jsonReq = new JsonObjectRequest(Method.GET, URL_FEED, (String)null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                VolleyLog.d(TAG, "Response: " + response.toString());
                if (response != null) {
                    parseJsonFeed(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        AppController.getInstance().addToRequestQueue(jsonReq);
    }
    return view;
}

private void parseJsonFeed(JSONObject response) {
    try {
        JSONArray feedArray = response.getJSONArray("feed");

        for (int i = 0; i < feedArray.length(); i++) {
            JSONObject feedObj = (JSONObject) feedArray.get(i);

            FeedItem item = new FeedItem();
            item.setId(feedObj.getInt("id"));
            item.setName(feedObj.getString("name"));

            String image = feedObj.isNull("image") ? null : feedObj.getString("image");
            item.setImage(image);
            item.setStatus(feedObj.getString("status"));
            item.setProfilePic(feedObj.getString("profilePic"));
            item.setTimeStamp(feedObj.getString("timeStamp"));

            String feedUrl = feedObj.isNull("url") ? null : feedObj.getString("url");
            item.setUrl(feedUrl);

            feedItems.add(item);
        }

        listAdapter.notifyDataSetChanged();
    } catch (JSONException e) {
        e.printStackTrace();
    }
}
}