public class AsyncFetch extends AsyncTask<String, Void, JSONObject> {

public AsyncFetch(Context context) {
    this.context = context;
}

private Context context;
private JSONObject jsonObject;
private onResponse onResponse;

public onResponse getOnResponse() {
    return onResponse;
}

public void setOnResponse(onResponse onResponse) {
    this.onResponse = onResponse;
}

@Override
protected JSONObject doInBackground(String... params) {
    // TODO Auto-generated method stub
    try {
        HttpGet get = new HttpGet(params[0]);
        HttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        jsonObject = new JSONObject(result);
    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return jsonObject;
}

@Override
protected void onPostExecute(JSONObject result) {
    // TODO Auto-generated method stub
    super.onPostExecute(result);
    this.onResponse.onResponse(result);
}

public interface onResponse {
    public void onResponse(JSONObject object);
}