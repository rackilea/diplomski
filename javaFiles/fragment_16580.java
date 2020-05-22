import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
* Created by Nisal on 13-Sep-17.
*/

public class GetStationsAPICall extends AsyncTask<String, Void, String> {

    LocalBroadcastManager localBroadcastManager; //This is the manager to send a result back to your activity

    GetStationsAPICall(Context ctx){
        localBroadcastManager = LocalBroadcastManager.getInstance(ctx); //No matter where you call this, it is the same object throughout your app.
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];

        if(method.equals("getStations")){

            try {
                HttpClient client = new DefaultHttpClient();
                String getURL = "http://api.gate.com/?lang=en";
                HttpGet httpGet = new HttpGet(getURL);
                httpGet .setHeader("Authorization", "Bearer 690");

                HttpResponse response = client.execute(httpGet);
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    //parse response.
                    String responseString = EntityUtils.toString(resEntity);
                    Log.e("Response", responseString;
                    return responseString; //This will be the parameter of your onPostExecute method
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String obj) {
        localBroadcastManager
            .sendBroadcast( //Sending the intent with the response!
                new Intent("StationsAPI") //Remember that IntentFilter? Here is where you declare where to send intent.
                    .putExtra("API_Response", obj)); //This is the extra data you want to send to your receivers.
    }
}