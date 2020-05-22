package room.temperature;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class RoomTemperatureActivity extends Activity {

    String result = null;
    StringBuilder sb=null;

    TextView TemperatureText, DateText;
    ArrayList<NameValuePair> nameValuePairs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TemperatureText = (TextView) findViewById(R.id.temperature); 
        DateText = (TextView) findViewById(R.id.date); 
        nameValuePairs = new ArrayList<NameValuePair>();

         RefreshValuesTask task = new RefreshValuesTask();
         task.execute("");
    }

    // The definition of our task class
    private class RefreshValuesTask extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            InputStream is = null;
            for (int i = 0; i < 10; i++) {          

            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://mywebsite.com/roomtemp/tempscript.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
            }

            catch(Exception e)  {
                Log.e("log_tag", "Error in http connection" + e.toString());
            }

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                sb = new StringBuilder();
                sb.append(reader.readLine());
                is.close();
                result=sb.toString();
                publishProgress(result);
            }

            catch(Exception e)  {
                Log.e("log_tag", "Error converting result " + e.toString());
             }
            }
            return result;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            setValues(values);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //System.out.println(result);
            setValues(result);
        }


    }

    public void setValues(String resultValue) {
        System.out.println(resultValue);
        String[] values = resultValue.split("&");

        TemperatureText.setText(values[0]);
        DateText.setText(values[1]);
    }
}