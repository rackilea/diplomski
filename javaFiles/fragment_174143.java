public class MainActivity extends Activity {
        Context context;

            TextView tv;
            final String URL = "http://news.google.com";

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                tv = (TextView) findViewById(R.id.textView1);
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
                            // Here you can do something with each element
                            //System.out.println(element.text());
                            //tv.setText(element.text());
                            //cannot update ui here. 
                            // use Log.i instead of System.out.println
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
                    tv.setText(result);
                }
            }
        }