package com.example.secondapp;
import com.example.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


 public class MainActivity extends Activity {

    Button btn1;
     EditText etxt1;
     TextView tvHttp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btn1=(Button)findViewById(R.id.button1);
       // etxt1=(EditText)findViewById(R.id.editText1);
        tvHttp = (TextView) findViewById(R.id.textView1);


        HttpGetter Obj = new HttpGetter();
        Obj.execute("http://10.0.2.2:8983/solr/collection1/select?q=mem&wt=json&indent=true");


        //StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());


    }



    public  class HttpGetter  extends AsyncTask <String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub

        BufferedReader reader=null;
        String data =null;

         try {


             HttpClient client = new DefaultHttpClient();

             URI uri = new URI(params[0]);

             HttpGet Gett = new HttpGet(uri);

             HttpResponse response= client.execute(Gett);

             InputStream stream = response.getEntity().getContent();

             reader = new BufferedReader(new InputStreamReader(stream));

             StringBuffer buffer = new StringBuffer("");
             String line="";
             String newline=System.getProperty("line.separator");

             while ((line= reader.readLine())!=null)
             {
                 buffer.append(line + newline);
             }
             reader.close();

             data= buffer.toString();
             return data;

         }

         catch (URISyntaxException e)
         {
             e.printStackTrace();
         } 
         catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally
        {
            if (reader != null){
                try{
                    reader.close();
                }catch (Exception e){

                }
            }

        }



         return null;

}

   @Override
   protected void onPostExecute(String result)
   {
       super.onPostExecute(result);
       tvHttp.setText(result);
   }


}}