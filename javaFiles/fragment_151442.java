package com.example.telugump3;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xavient.kwickhelp.testappstack.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

public class DownloadActivity extends Activity{
    Activity context;
    HttpPost httppost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    ProgressDialog pd;
    CustomAdapter adapter;
    ListView listProduct;
    ArrayList<String> records;
    String mname;
    String sText;
    private long enqueue;
    private DownloadManager dm;

    protected void onCreate(Bundle savedInstanceState) {
        //TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_activity);
        context=this;
        records=new ArrayList<String>();
        listProduct=(ListView)findViewById(R.id.product_list);
        adapter=new CustomAdapter(context, R.layout.thirdlist_item,R.id.pro_name, records);
        listProduct.setAdapter(adapter);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            mname =(String) b.getString("song_name");
            System.out.print(mname);

        }

        listProduct.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id){

                String sText = ((TextView) v.findViewById(R.id.pro_name)).getText().toString();

            }

        });

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                    long downloadId = intent.getLongExtra(
                            DownloadManager.EXTRA_DOWNLOAD_ID, 0);
                    Query query = new Query();
                    query.setFilterById(enqueue);
                    Cursor c = dm.query(query);
                    if (c.moveToFirst()) {
                        int columnIndex = c
                                .getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if (DownloadManager.STATUS_SUCCESSFUL == c
                                .getInt(columnIndex)) {

                            ImageView view = (ImageView) findViewById(R.id.imageView);
                            String uriString = c
                                    .getString(c
                                            .getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                            view.setImageURI(Uri.parse(uriString));
                        }
                    }
                }
            }
        };

        registerReceiver(receiver, new IntentFilter(
                DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    public void onClick(View view) {
        dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        Request request = new Request(
                Uri.parse(sText));
        enqueue = dm.enqueue(request);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        //create a LayoutTransition object
        return true;
    }

    @Override
    public void onStart(){
        super.onStart();
        //execute background task
       new BackTask().execute();


    }

    //background process to make a request to server and list product information
    private class BackTask extends AsyncTask<Void,Void,Void>{
        protected void onPreExecute(){
            super.onPreExecute();
            pd = new ProgressDialog(context);
            pd.setTitle("Retrieving data");
            pd.setMessage("Please wait.");
            pd.setCancelable(true);
            pd.setIndeterminate(true);
            pd.show();

        }

        protected Void doInBackground(Void...params){





            //parse json data
            try{

                String result = callWebService("http://necrecords.16mb.com/getlink.php?password=acchata%20mucchata");
                JSONArray jArray =new JSONArray(result);
                JSONArray resArray = new JSONArray(result);
                for (int i=0; i<resArray.length();i++){
                    JSONObject res = resArray.getJSONObject(i);

                    String link = res.getString("link");
                    String test = res.getString("test");
                    String record = link+"__"+test;
                    Log.v("result ==== ", link + "   ,   " + test);
                    records.add(record);
                }



            }
            catch(Exception e){
                Log.e("ERROR", "Error pasting data "+e.toString());

            }

            return null;
        }


        protected void onPostExecute(Void result){

            if(pd!=null) pd.dismiss(); //close dialog
            adapter.notifyDataSetChanged(); //notify the ListView to get new records

        }

        public void showDownload(View view) {
            Intent i = new Intent();
            i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
            startActivity(i);
        }

    }

    public String callWebService(String urlvalue) throws Exception {
        System.setProperty("http.keepAlive", "false");
        URL u = new URL(urlvalue);
        URLConnection conn = u.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));
        StringBuffer buffer = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            buffer.append(inputLine);
        in.close();
        // System.out.println(buffer.toString());
        return buffer.toString();

    }
}