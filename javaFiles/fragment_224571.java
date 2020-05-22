public class MainActivity extends AppCompatActivity {

    private MediaPlayer mPlayer = new MediaPlayer();
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();

    public class HttpRequestTask extends AsyncTask<Void,Void,Items[]> {
        protected Items[] doInBackground(Void... params) {
            final Request request = new Request.Builder()
                .url("https://api.myjson.com/bins/1z98u")
                .build();

            Items[] items = null;

            try {
                final com.squareup.okhttp.Response response = client.newCall(request).execute();

                if(response.isSuccessful()) {
                    final RadioProgramInfo radioProgramInfo = gson.fromJson(response.body().charStream(), RadioProgramInfo.class);

                    items = radioProgramInfo.getResponse().getItems();

                } else {
                    throw new RuntimeException("ooops!");
                }

            } catch (Throwable t) {
                Log.e("MainActivity", t.getMessage(), t);
            }

            return items;
        }

        @Override
        protected void onPostExecute(Items[] items) {
            try {
                mPlayer.setDataSource(items[0].getSite_url());
                mPlayer.prepareAsync();

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        new HttpRequestTask().execute();
    }

}