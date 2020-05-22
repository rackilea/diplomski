import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.independentsoft.exchange.Appointment;
import com.independentsoft.exchange.Body;
import com.independentsoft.exchange.Folder;
import com.independentsoft.exchange.ItemId;
import com.independentsoft.exchange.Service;
import com.independentsoft.exchange.ServiceException;
import com.independentsoft.exchange.StandardFolder;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        new MyAsyncTask().execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class MyAsyncTask extends AsyncTask<String, Integer, String> {


        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            String s=postData(params);
            return s;
        }

        protected void onPostExecute(String result){

        }
        protected void onProgressUpdate(Integer... progress){

        }

        public String postData(String valueIWantToSend[]) {

            String returnValue = "";
            try {
                Service service = new Service("https:192.168.2.105/ews/Exchange.asmx", "John","xxxxx");

                Folder inboxFolder = service.getFolder(StandardFolder.INBOX);

                Log.w("inboxFolder", inboxFolder.getDisplayName());

                returnValue = inboxFolder.getDisplayName();

            }
            catch (ServiceException ex)
            {
                Log.w("ServiceException", ":" + ex.getFaultCode());
                Log.w("ServiceException", ":" + ex.getFaultString());
                Log.w("ServiceException", ":" + ex.getMessage());
                Log.w("ServiceException", ":" + ex.getXmlMessage());
                Log.w("ServiceException", ":" + ex.getResponseCode());
                Log.w("ServiceException", ":" + ex.getRequestBody());
            }
            catch (Exception ex)
            {
                Log.w("Exception", ex.getMessage());
            }

            return returnValue;
        }
    }
}