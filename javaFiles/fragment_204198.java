public class AddInfo extends AsyncTask<String, Void, ContentValues> {

private final Context context;
private final ProgressDialog loading;

public AddInfo(Context context) {
    this.context = context;
}

private ContentValues handleActionSend(String name, String weather, String date2, String status, String timeIn, String timeOut) {
    ContentValues retour = new ContentValues();
    retour.put("success", false);

    try {
        HttpPost post = new HttpPost(Config.ADD_INFORMATION);
        post.addHeader("Accept", "application/json");
        List<NameValuePair> postParams = new ArrayList<NameValuePair>();
        postParams.add(new BasicNameValuePair(Config.KEY_USER_NAME, name));
        postParams.add(new BasicNameValuePair(Config.KEY_WEATHER, weather));
        postParams.add(new BasicNameValuePair(Config.KEY_DATE, date2));
        postParams.add(new BasicNameValuePair(Config.KEY_STATUS, status));
        postParams.add(new BasicNameValuePair(Config.KEY_TIMEIN, timeIn));
        postParams.add(new BasicNameValuePair(Config.KEY_TIMEOUT, timeOut));

        post.setEntity(new UrlEncodedFormEntity(postParams, HTTP.UTF_8));
        HttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(post);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        JSONObject json = new JSONObject(result.toString());

        retour.put("success", true);
        retour.put("lastId", json.getInt("lastId"));
    } catch (MalformedURLException e) {
        retour.put("message", "MalformedURLException Error: " + e.getLocalizedMessage());
    } catch (UnsupportedEncodingException e) {
        retour.put("message", "UnsupportedEncodingException Error: " + e.getLocalizedMessage());
    } catch (IOException e) {
        retour.put("message", "IOException Error: " + e.getLocalizedMessage());
    } catch (Exception e) {
        retour.put("message", "Exception Error: " + e.getLocalizedMessage());
    }
    return retour;
}


@Override
protected ContentValues doInBackground(String... args) {
    loading = ProgressDialog.show(context, "Please Wait", null, true, true);
    return handleActionSend(args[0], args[1], args[2], args[3], args[4], args[5]);
}

@Override
protected void onPostExecute(ContentValues contentValues) {
    super.onPostExecute(contentValues);
    loading.dismiss();
    String message;
    if(contentValues.getAsBoolean("success")) {
        message = "Inserted successfully: "+ contentValues.getAsInt("lastId");
    } else {
        message = "An error has occured!\n"+ contentValues.getAsString("message");
    }
    Toast.makeText(context, message, Toast.LENGTH_LONG).show();
}
}