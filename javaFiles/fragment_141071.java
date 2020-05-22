import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;


         new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... params) {

                StringBuilder responseString = new StringBuilder();
                try {
                    HttpURLConnection urlConnection = (HttpURLConnection) new URL("http://you_url_here").openConnection();
                    urlConnection.setRequestMethod("GET");
                    int responseCode = urlConnection.getResponseCode();
                    if (responseCode == 200){
                        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            responseString.append(line);
                        }
                    }
                    urlConnection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return responseString.toString();
            }

            @Override
            protected void onPostExecute(String o) {
                Toast toast = Toast.makeText(context, (CharSequence) o, Toast.LENGTH_SHORT);
                toast.show();

                /* if your json structure this type then it will work now 
                * {
                *   "id":123,
                *   "name":abc,
                *   "status":"ok"
                * }
                */
                try {
                    JSONObject jsonObject = new JSONObject(o);
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.getString("name");
                    String status = jsonObject.getString("status");
                    Toast.makeText(MainActivity.this, "id #"+id+", name #"+name+", status #"+status, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) { e.printStackTrace(); }


            }
        }.execute("");
    }
}