public class MainActivity extends Activity implements OnClickListener {

    private Button loginTumblrBtn;
    private CommonsHttpOAuthConsumer consumer;
    private CommonsHttpOAuthProvider provider;
    private SharedPreferences preferences;
    private Uri uri;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("tumblr", Context.MODE_PRIVATE);

        loginTumblrBtn = (Button) findViewById(R.id.login_tumblr);
        loginTumblrBtn.setOnClickListener(this);

        consumer = new CommonsHttpOAuthConsumer(Constant.CONSUMER_KEY,
                Constant.CONSUMER_SECRET);

        provider = new CommonsHttpOAuthProvider(Constant.REQUEST_TOKEN_URL,
                Constant.ACCESS_TOKEN_URL, Constant.AUTH_URL);

        uri = this.getIntent().getData();

        if (uri != null
                && uri.getScheme().equals(Constant.OAUTH_CALLBACK_SCHEME)) {

            loginTumblrBtn.setText(getString(R.string.logout_tumblr));
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {

                    try {
                        consumer.setTokenWithSecret(
                                preferences.getString("requestToken", ""),
                                preferences.getString("requestSecret", ""));

                        provider.setOAuth10a(true);
                        provider.retrieveAccessToken(consumer,
                                uri.getQueryParameter(OAuth.OAUTH_VERIFIER));

                        consumer.setTokenWithSecret(consumer.getToken(),
                                consumer.getTokenSecret());

                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("token", consumer.getToken());
                        editor.putString("token_secret",
                                consumer.getTokenSecret());
                        editor.commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            loginTumblrBtn.setText(getString(R.string.login_tumblr));
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
        case R.id.login_tumblr:
            if (preferences.getString("token", null) != null) {

                loginTumblrBtn.setText(getString(R.string.login_tumblr));
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("token", null);
                editor.putString("token_secret", null);
                editor.commit();
            } else {
                progressDialog = ProgressDialog.show(this, "Loading",
                        "Please Wait...");
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            String authUrl = provider.retrieveRequestToken(
                                    consumer, Constant.CALLBACK_URL);
                            SharedPreferences.Editor editor = preferences
                                    .edit();
                            editor.putString("requestToken",
                                    consumer.getToken());
                            editor.putString("requestSecret",
                                    consumer.getTokenSecret());
                            editor.commit();
                            startActivity(new Intent(
                                    "android.intent.action.VIEW", Uri
                                            .parse(authUrl)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
            break;
        }

    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        if (preferences.getString("token", null) != null) {
            loginTumblrBtn.setText(getString(R.string.logout_tumblr));
        } else {
            loginTumblrBtn.setText(getString(R.string.login_tumblr));
        }
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}