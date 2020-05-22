public static final String ACTION                       =   "org.APP.APP.MESSAGE";
public static final String PARSE_EXTRA_DATA_KEY         =   "com.parse.Data";
public static final String PARSE_JSON_CHANNEL_KEY       =   "com.parse.Channel";
public static final String TAG                          =   "articleId";

@Override
//
public void onReceive(Context context, Intent intent) {


    Bundle extras = intent.getExtras();
    String jsonData = extras.getString( "com.parse.Data" );
    JSONObject jObject;
    Log.i("PUSH", String.format("push received: %s", jsonData));
    try {
        jObject = new JSONObject(jsonData);
        String articleId = jObject.getString("articleId");
        Log.d("PUSH URL",
                "http://MYaweSOMEapp.com/articles/" + articleId);


        Intent webViewIntent = new Intent(context, MainActivity.class);
        webViewIntent.putExtra("url",  "http://MYaweSOMEapp.com/app/articles/" + articleId);
        webViewIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(webViewIntent);

    } catch (JSONException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

}