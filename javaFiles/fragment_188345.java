public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "YOUR_TWITTER_KEY";
    private static final String TWITTER_SECRET = "YOUR_TWITTER_SECRET";
    TwitterLoginButton loginButton;
    SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig), new Crashlytics());
        setContentView(R.layout.activity_main);
        shared = getSharedPreferences("demotwitter", Context.MODE_PRIVATE);
        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
           @Override
           public void success(Result<TwitterSession> result) {
               // Do something with result, which provides a TwitterSession for making API calls
                TwitterSession session = Twitter.getSessionManager()
                        .getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;

//Here we get all the details of user's twitter account

                System.out.println(result.data.getUserName()
                        + result.data.getUserId());
                Twitter.getApiClient(session).getAccountService()
                        .verifyCredentials(true, false, new Callback<User>() {

                            @Override
                            public void success(Result<User> userResult) {

                                User user = userResult.data;
//Here we get image url which can be used to set as image wherever required.      
                 System.out.println(user.profileImageUrl+" "+user.email+""+user.followersCount);

                            }

                            @Override
                            public void failure(TwitterException e) {

                            }

                        });
                shared.edit().putString("tweetToken", token).commit();
                shared.edit().putString("tweetSecret", secret).commit();
                TwitterAuthClient authClient = new TwitterAuthClient();
                authClient.requestEmail(session, new Callback<String>() {
                    @Override
                    public void success(Result<String> result) {
                        // Do something with the result, which provides the
                        // email address
                        System.out.println(result.toString());
                        Log.d("Result", result.toString());
                        Toast.makeText(getApplicationContext(), result.data,
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        // Do something on failure
                        System.out.println(exception.getMessage());
                    }
                });
                MyTwitterApiClient apiclients=new MyTwitterApiClient(session);
                apiclients.getCustomService().list(result.data.getUserId(), new Callback<Response>() {

                    @Override
                    public void failure(TwitterException arg0) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void success(Result<Response> arg0) {
                        // TODO Auto-generated method stub
                        BufferedReader reader = null;
                        StringBuilder sb = new StringBuilder();
                        try {

                            reader = new BufferedReader(new InputStreamReader(arg0.response.getBody().in()));

                            String line;

                            try {
                                while ((line = reader.readLine()) != null) {
                                    sb.append(line);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        String result = sb.toString();
                    System.out.println("Response is>>>>>>>>>"+result);
                    try {
                        JSONObject obj=new JSONObject(result);
                        JSONArray ids=obj.getJSONArray("ids");
              //This is where we get ids of followers
                        for(int i=0;i<ids.length();i++){
                        System.out.println("Id of user "+(i+1)+" is "+ids.get(i));
                        }
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    }

                });
           }

           @Override
           public void failure(TwitterException exception) {
               // Do something on failure
           }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

}