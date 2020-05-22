import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class AsyncTaskActivity extends Activity implements OnClickListener {

Button btn;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    btn = (Button) findViewById(R.id.button1);
    // because we implement OnClickListener we only have to pass "this"
    // (much easier)
    btn.setOnClickListener(this);
}

public void onClick(View view) {
    // detect the view that was "clicked"
    switch (view.getId()) {
    case R.id.button1:
        new LongOperation().execute("");
        break;
    }
}

private class LongOperation extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
         String url = params[0];

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);           
        request.setHeader("Content-Type", "text/xml");
        HttpResponse response;
        try {
            response = httpClient.execute(request);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        // Result is in String Format
        // you can use JSON api to convert into JSONObject

    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected void onProgressUpdate(Void... values) {}
}