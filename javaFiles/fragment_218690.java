package com.test;

import java.io.BufferedReader;
import java.io.DataOutputStream; 
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream; 
import java.net.HttpURLConnection;
import java.net.URL; 
import java.net.URLConnection; 


import java.util.HashMap;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity; 
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle; 
import android.util.Log; 
import android.view.Menu;
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.TextView;
import android.widget.Toast;


public class Test extends Activity { 
    static final String TAG = "Test"; 
    // Called when the activity is first created.  

    protected static EditText username; 
    protected static EditText password;
    TextView tview;
    String uname ="";
    JSONObject json;
    URL url;

    @Override 
    public void onCreate(Bundle icicle) { 
        super.onCreate(icicle); 
        setContentView(R.layout.testlogin); 

        username = (EditText)findViewById(R.id.username); 
        password = (EditText)findViewById(R.id.password);
        tview = (TextView)findViewById(R.id.view);
        Toast.makeText(this, "Started",1).show();
        Log.v(TAG,"\nStarted\n"); 
    } 

    public void login(View v) { //in testlogin.xml//android:onClick="login"
        Toast.makeText(this, "button pressed",1).show();
        Log.v(TAG, "button pressed");
        //tview.append("clicked\n");

        HashMap<String, String> hasmap=new HashMap<String, String>();
        hasmap.put("user",username.getText().toString());
        hasmap.put("pass",password.getText().toString());
        json = new JSONObject(hasmap);
        String sJSON = json.toString();
        new toServlet().execute(sJSON);//sends the jsonString to a aSync task
    }

    private class toServlet extends AsyncTask<String, Void, String> {
        @Override

        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                Log.v(TAG,"In background");
                return connection(urls[0]);//could send message to multible uls
            } catch (IOException e) {
                Log.v(TAG,"Error: "+e);
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
    }
    private String connection (String sJSON)throws IOException{//creates new connection each time
        Log.v(TAG, "Connection");
        Log.v(TAG,"In connection "+sJSON);
        URL url;
        InputStream is = null;
        HttpURLConnection conServlet;

        url = new URL("http://10.0.2.2:8080/CheckmateServerSuport/servlet?TAG="+sJSON);
        conServlet = (HttpURLConnection) url.openConnection();
        conServlet.setDoInput(true);
        //con.setDoInput(true);
        conServlet.setRequestMethod("POST");//can be get

        conServlet.connect();//makes the connection and send


        //Response
        is = conServlet.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Log.v(TAG,"Sent String ");

        String back = br.readLine();
        Log.v(TAG,""+back);

        return back;

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}