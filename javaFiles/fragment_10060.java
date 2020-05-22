public class MainActivity extends AppCompatActivity {

    Twitch twitch;
    JSONObject jsonObj;  //instance variable which can be accessed anywhere in the class code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        twitch = new Twitch("aksynial");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {

            System.out.println("REFRESHING");
            new TwitchAsync().execute();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class TwitchAsync extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            String str = twitch.getJson("streams");
            return str;
        }

        @Override
        protected void onPostExecute(String result){
            Toast.makeText(MainActivity.this, "result: " + result, Toast.LENGTH_LONG).show();

            //testing buildJSON:
            //assign to the instance variable jsonObj
            jsonObj = twitch.buildJSON(result);

            Log.d("JSON Result: ",  jsonObj.toString());
        }
    }
}