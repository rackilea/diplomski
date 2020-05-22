public class Example extends Activity { 

 Context context = null; 
   ListView listView = null; 
 TextView footer; 
 int offset = 0; 
 ProgressDialog pDialog; 
 ArrayList<Tumblr> tumblrs;
private String searchUrl = "http://api.tumblr.com/v2/blog/factsandchicks.com/posts?   api_key=API_KEY&offset=0"; 

@Override 
public void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState); 
setContentView(R.layout.main);  
try { 
    tumblrs = getTumblrs(); 
    listView = (ListView) findViewById(R.id.list); 
    View v = getLayoutInflater().inflate(R.layout.footer_layout, null); 
    footer = (TextView) v.findViewById(R.id.tvFoot); 
    listView.addFooterView(v); 
    listView.setAdapter(new UserItemAdapter(this, R.layout.listitem)); 

} catch (ClientProtocolException e) { 
    e.printStackTrace(); 
} catch (IOException e) { 
    e.printStackTrace(); 
} catch (JSONException e) { 
    e.printStackTrace(); 
} 

footer.setOnClickListener(new View.OnClickListener() { 

    @Override 
    public void onClick(View v) { 
        new loadMoreListView().execute(); 
    } 
}); 



public class UserItemAdapter extends ArrayAdapter<Tumblr> { 

public UserItemAdapter(Context context, int imageViewResourceId) { 
    super(context, imageViewResourceId, tumblrs); 
} 

@Override 
public View getView(int position, View convertView, ViewGroup parent) { 
    View v = convertView; 
    if (v == null) { 

        LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
        v = vi.inflate(R.layout.listitem, null); 

    } 

    Tumblr tumblr = tumblrs.get(position); 
    if (tumblr != null) { 

        ImageView image = (ImageView) v.findViewById(R.id.avatar); 

        if (image != null) { 
            image.setImageBitmap(getBitmap(tumblr.image_url)); 
        } 
    } 
    return v; 
} 
} 


public Bitmap getBitmap(String bitmapUrl) { 
try { 
    URL url = new URL(bitmapUrl); 
    return BitmapFactory.decodeStream(url.openConnection() 
            .getInputStream()); 
} catch (Exception ex) { 
    return null; 
} 
} 

 public ArrayList<Tumblr> getTumblrs() throws ClientProtocolException, 
    IOException, JSONException { 
searchUrl = "http://api.tumblr.com/v2/blog/factsandchicks.com/posts?api_key=API_KEY&offset=0"; 

ArrayList<Tumblr> tumblrs = new ArrayList<Tumblr>(); 

HttpClient client = new DefaultHttpClient(); 
HttpGet get = new HttpGet(searchUrl); 

ResponseHandler<String> responseHandler = new BasicResponseHandler(); 

String responseBody = null; 
try { 
    responseBody = client.execute(get, responseHandler); 
} catch (Exception ex) { 
    ex.printStackTrace(); 
} 

JSONObject jsonObject = new JSONObject(responseBody); 

JSONArray posts = jsonObject.getJSONObject("response").getJSONArray( 
        "posts"); 
for (int i = 0; i < posts.length(); i++) { 
    JSONArray photos = posts.getJSONObject(i).getJSONArray("photos"); 
    for (int j = 0; j < photos.length(); j++) { 
        JSONObject photo = photos.getJSONObject(j); 
        String url = photo.getJSONArray("alt_sizes").getJSONObject(0) 
                .getString("url"); 

        Tumblr tumblr = new Tumblr(url); 
        tumblrs.add(tumblr); 
    } 
} 
return tumblrs; 
 } 
 }

public class Tumblr { 

public String image_url; 

public Tumblr(String url) { 

    this.image_url = url; 
} 
 } 

 private class loadMoreListView extends AsyncTask<Void, Void, Void> { 

@Override 
protected void onPreExecute() { 
    // Showing progress dialog before sending http request 
    pDialog = new ProgressDialog(Example.this); 
    pDialog.setMessage("Please wait.."); 
    pDialog.setIndeterminate(true); 
    pDialog.setCancelable(false); 
    pDialog.show(); 
} 

@Override 
protected Void doInBackground(Void... unused) { 
    // TODO Auto-generated method stub 
    runOnUiThread(new Runnable() { 
        public void run() { 
            // increment current page 
            offset += 20; 

            // Next page request 

            searchUrl = "http://api.tumblr.com/v2/blog/factsandchicks.com/posts?     api_key=API_KEY&limit=2&offset=" 
                    + offset; 



            HttpClient client = new DefaultHttpClient(); 
            HttpGet get = new HttpGet(searchUrl); 

            ResponseHandler<String> responseHandler = new BasicResponseHandler(); 

            String responseBody = null; 
            try { 
                responseBody = client.execute(get, responseHandler); 
            } catch (Exception ex) { 
                ex.printStackTrace(); 
            } 

            JSONObject jsonObject; 
            try { 
                jsonObject = new JSONObject(responseBody); 

                JSONArray posts = jsonObject.getJSONObject("response") 
                        .getJSONArray("posts"); 
                for (int i = 0; i < posts.length(); i++) { 
                    JSONArray photos = posts.getJSONObject(i) 
                            .getJSONArray("photos"); 
                    for (int j = 0; j < photos.length(); j++) { 
                        JSONObject photo = photos.getJSONObject(j); 
                        String url = photo.getJSONArray("alt_sizes") 
                                .getJSONObject(0).getString("url"); 

                        Tumblr tumblr = new Tumblr(url); 
                        tumblrs.add(tumblr); 

                    } 
                } 

            } catch (JSONException e) { 
                // TODO Auto-generated catch block 
                e.printStackTrace(); 
            } 

            // get listview current position - used to maintain scroll 
            // position 
            int currentPosition = listView.getFirstVisiblePosition(); 

            // Appending new data to tumblrs ArrayList 


            // Setting new scroll position 
            listView.setSelectionFromTop(currentPosition + 1, 0); 

        } 
    }); 

    return null; 
} 

protected void onPostExecute(Void unused) { 
    pDialog.dismiss(); 
} 

}