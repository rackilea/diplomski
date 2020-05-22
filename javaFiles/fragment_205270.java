@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.chat_box);// sd

    final Functions function = new Functions();
    final SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(getBaseContext());
    where = prefs.getString("chat", "null");
    new AsyncTask<String, Void, String>() {
        @Override
        protected String doInBackground(String... args) {
            return function.getInbox(args[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView inbox = (TextView) findViewById(R.id.inbox);
            inbox.setText(result);
        }

    }.execute(where);
}