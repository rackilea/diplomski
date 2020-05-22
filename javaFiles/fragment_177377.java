import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    public EditText uname,pwd;
    Button btnlog1;
    TextView invalid;
    public Button btncancel1;
    public String db_select;
     String mUname;
     String mPwd;
    String temp;
    Intent intObj;
    Intent intent = null;

Boolean isInternetPresent = false;
    ConnectionDetector cd;
    private final String SERVICE_URL = "http://www.gpspatronus.com:8080/app/applogin.php";
    private final String TAG = "MainActivity";
    public static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        MainActivity.this.setContentView(R.layout.activity_main);
        uname=(EditText)findViewById(R.id.editText1);
        pwd=(EditText)findViewById(R.id.editText2);
        invalid=(TextView)findViewById(R.id.textView3);
        btnlog1=(Button)findViewById(R.id.button1);
        //btncancel1=(Button)findViewById(R.id.button2);
        //SERVICE_URL=ServerURL.URL+"/msd";

        btnlog1.setOnClickListener(new View.OnClickListener()
        {           
            @Override
            public void onClick(View v) 
            {
                mUname=uname.getText().toString();
                mPwd=pwd.getText().toString();
                SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("EMP_ID",mUname);
                editor.putString("EMP_PWD", mPwd);
                editor.commit(); //important, otherwise it wouldn't save.
//                  display("Login clicked");
                if(!mUname.equalsIgnoreCase("") && !mPwd.equalsIgnoreCase(""))
                {
                    cd = new ConnectionDetector(getApplicationContext());
                    isInternetPresent = cd.isConnectingToInternet();
                    //Toast.makeText(MainActivity.this, isInternetPresent, Toast.LENGTH_LONG).show();
                    if(isInternetPresent)
                    {


                    try
                    {
                        validat_user(mUname,mPwd);

                    }
                    catch(Exception e)
                    {
                        display("Network error.\nPlease check with your network settings.");
                        uname.setText("");
                        pwd.setText("");
                    }
                    }
                    else
                    {
                        display("No Internet Connection...");
                    }

                }
                else
                {
                    invalid.setText("Please enter the data");
                }
            }
        });

    }
    public void display(String msg) 
    {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }


    private void validat_user(String stg1, String stg2)
    {
        db_select=stg1;
        WebServiceTask wst = new WebServiceTask(WebServiceTask.POST_TASK, this, "Login in progress...");

        wst.addNameValuePair("EMP_ID", stg1);
        wst.addNameValuePair("EMP_PWD", stg2);

        wst.execute(new String[] { SERVICE_URL });

    }
    @SuppressWarnings("deprecation")
    public void no_net()
    {
        display( "No Network Connection");
        final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("No Internet Connection");
        alertDialog.setMessage("You don't have internet connection.\nElse please check the Internet Connection Settings.");
        //alertDialog.setIcon(R.drawable.error_info);
        alertDialog.setCancelable(false);
        alertDialog.setButton("Close", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int which)
            {   
                alertDialog.cancel();
                MainActivity.this.finish();
                System.exit(0);
            }
        });
        alertDialog.setButton2("Use Local DataBase", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int which)
            {
                display( "Accessing local DataBase.....");
                alertDialog.cancel();
            }
        });
        alertDialog.show();
    }

    private class WebServiceTask extends AsyncTask<String, Integer, String> {

        public static final int POST_TASK = 1;

        private static final String TAG = "WebServiceTask";

        // connection timeout, in milliseconds (waiting to connect)
        private static final int CONN_TIMEOUT =12000;

        // socket timeout, in milliseconds (waiting for data)
        private static final int SOCKET_TIMEOUT =12000;

        private int taskType = POST_TASK;
        private Context mContext = null;
        private String processMessage = "Processing...";

        private ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();

        private ProgressDialog pDlg = null;

        public WebServiceTask(int taskType, Context mContext, String processMessage) {

            this.taskType = taskType;
            this.mContext = mContext;
            this.processMessage = processMessage;
        }

        public void addNameValuePair(String name, String value) {

            params.add(new BasicNameValuePair(name, value));
        }

        @SuppressWarnings("deprecation")
        private void showProgressDialog() {

            pDlg = new ProgressDialog(mContext);
            pDlg.setMessage(processMessage);
            pDlg.setProgressDrawable(mContext.getWallpaper());
            pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDlg.setCancelable(false);
            pDlg.show();

        }

        @Override
        protected void onPreExecute() {

            showProgressDialog();

        }

        protected String doInBackground(String... urls) {

            String url = urls[0].toString();
            String result = "";
            HttpResponse response = doResponse(url);
            if (response == null) {
                return result;
            } else {

                try {

                    result = inputStreamToString(response.getEntity().getContent());

                } catch (IllegalStateException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);

                } catch (IOException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                }
                catch(Exception e)
                {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                }

            }

            return result;
        }

        @Override
        protected void onPostExecute(String response) {

            handleResponse(response);
            pDlg.dismiss();

        }

        // Establish connection and socket (data retrieval) timeouts
        private HttpParams getHttpParams() {

            HttpParams htpp = new BasicHttpParams();

            HttpConnectionParams.setConnectionTimeout(htpp, CONN_TIMEOUT);
            HttpConnectionParams.setSoTimeout(htpp, SOCKET_TIMEOUT);

            return htpp;
        }

        private HttpResponse doResponse(String url) {

            // Use our connection and data timeouts as parameters for our
            // DefaultHttpClient
            HttpClient httpclient = new DefaultHttpClient(getHttpParams());

            HttpResponse response = null;

            try {
                switch (taskType) {

                case POST_TASK:

                    HttpPost httppost= new HttpPost(url);
                    httppost.setEntity(new UrlEncodedFormEntity(params));
                    response = httpclient.execute(httppost);

                    break;
                }
            } 
            catch (Exception e) {
            //  display("Remote DataBase can not be connected.\nPlease check network connection.");

                Log.e(TAG, e.getLocalizedMessage(), e);
                return null;

            }

            return response;
        }

        private String inputStreamToString(InputStream is) {

            String line = "";
            StringBuilder total = new StringBuilder();

            // Wrap a BufferedReader around the InputStream
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try {
                // Read response until the end
                while ((line = rd.readLine()) != null) {
                    total.append(line);
                }
            } catch (IOException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }
            catch(Exception e)
            {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }

            // Return full string
            return total.toString();
        }

    }
    public void handleResponse(String response) 

    {    
    //display("Response:"+response);
        if(!response.equalsIgnoreCase(""))
        {
            JSONObject jso;
            try {
                jso = new JSONObject(response);


                    String status = jso.getString("status");
                    int valid=jso.getInt("valid");
              //     display("Welcome : "+UName);
                 if(valid>0)
                 {
                    if( status.equalsIgnoreCase("") || status==null ||  status.equalsIgnoreCase("Failed"))
                    {
                        invalid.setText("Invalid password");
                        //reset();
                        pwd.setText("");
                    }
                    else
                    {
                        //display(status);
                        intObj=new Intent(MainActivity.this,Design_Activity.class);
                        startActivity(intObj);
                        MainActivity.this.finish();     
                    }

                 }
                 else
                 {
                     invalid.setText("Invalid userid");
                     uname.setText("");
                 }
                }
            catch (JSONException e1) {

                Log.e(TAG, e1.getLocalizedMessage(), e1);
            }
            catch(Exception e)
            {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }


        }
        else
        {
            display("Could not able to reach Server!");
        }


    }
    public void reset()
    {


        pwd.setText("");
        uname.setText("");
    }

}