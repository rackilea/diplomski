public class MainActivity extends AppCompatActivity {

private String PostUrl = "http://your.ip.address.here:3000";
private String JSON = "{\"test\":\"100\"}";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    new PostTask().execute();
}

class PostTask extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... voids) {
        HttpURLConnection con = null;

        try {
            URL url = new URL(PostUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/JSON; charset=utf-8");

            Log.d("debug", "----- All right here -----");
            OutputStream os = con.getOutputStream();
            Log.d("debug", "----- This message is not displayed -----");
            os.write(JSON.getBytes("UTF-8"));
            os.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s!=null) {
            System.out.println(s);
        } else {
            System.out.println("Result not found");
        }
    }
}