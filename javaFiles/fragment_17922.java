public class MainActivity extends AppCompatActivity {

public static final String LOG_TAG = MainActivity.class.getSimpleName();
private TextView resultTextView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    resultTextView = findViewById(R.id.textView);
    new Tasking().execute();
}

class Tasking extends AsyncTask<Integer, Integer, String> {
    @Override
    protected String doInBackground(Integer... integers) {
        StringWriter sw = new StringWriter();
        try {
            URL url = new URL("https://www.google.com/");
            InputStream inputStream = url.openConnection().getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            char[] buffer = new char[1024 * 16];
            int readLength;
            while (-1 != (readLength = br.read(buffer))) {
                sw.write(buffer, 0, readLength);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }
        return sw.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.v(LOG_TAG, "Response:" + s);
        resultTextView.setText(s);
    }
}