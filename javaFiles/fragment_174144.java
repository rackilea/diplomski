public class MainActivity extends Activity {
    Context context;
    ArrayList<String> aa = new ArrayList<String>();
        ListView lv;
        final String URL = "http://news.google.com";

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            lv= (ListView) findViewById(R.id.listView1);
            new MyTask().execute(URL);
        }

        private class MyTask extends AsyncTask<String, Void, String> {
            ProgressDialog prog;
            String title = "";

            @Override
            protected void onPreExecute() {
                prog = new ProgressDialog(MainActivity.this);
                prog.setMessage("Loading....");
                prog.show();
            }

            @Override
            protected String doInBackground(String... params) {
                try {
                    Document doc = Jsoup.connect(params[0]).get();
                    Element tableHeader = doc.select("tr").first();

                    for (Element element : tableHeader.children()) {
                        aa.add(element.text().toString());
                    }

                    title = doc.title();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return title;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                prog.dismiss();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,aa);
                lv.setAdapter(adapter);
            }
        }
    }