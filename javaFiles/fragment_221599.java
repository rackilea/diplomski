package imo.meteoiraq;

import android.os.Handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Timestamp;

public class MainActivity extends AppCompatActivity {
    RequestQueue rq;
    TextView timeDesc, tempDesc, windspeedDesc, windguestDesc, humdityDesc;
    int ages;
    int temp;
    int windspeed;
    int windguest;
    int humdity;
    long timeupdate;

    String url = "stationlookup?station=I1410&units=metric&v=2.0&format=json";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq = Volley.newRequestQueue(this);

        timeDesc = (TextView) findViewById(R.id.timeupdateDesc);
        tempDesc = (TextView) findViewById(R.id.tempid);
        windspeedDesc = (TextView) findViewById(R.id.windid);
        windguestDesc = (TextView) findViewById(R.id.windgustid);
        humdityDesc = (TextView) findViewById(R.id.humdid);

        sendjsonrequest();
    }

    public void sendjsonrequest() {
 final ProgressDialog dialog = ProgressDialog.show(this, null, "Please Wait");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
 dialog.dismiss();
                try {

                    JSONObject stationsJO = response.getJSONObject("stations");
                    JSONObject I1410JO = stationsJO.getJSONObject("I1410");
                    temp = I1410JO.getInt("temperature");
                    windspeed = I1410JO.getInt("wind_speed");
                    windguest = I1410JO.getInt("wind_gust_speed");
                    humdity = I1410JO.getInt("humidity");
                    timeupdate = I1410JO.getLong("updated") * 1000L;

                    tempDesc.setText(Integer.toString(temp));
                    windspeedDesc.setText(Integer.toString(windspeed));
                    windguestDesc.setText(Integer.toString(windguest));
                    humdityDesc.setText(Integer.toString(humdity));
                    timeDesc.setText(getDate(timeupdate));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
 dialog.dismiss();
            }
        });
        rq.add(jsonObjectRequest);
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sendjsonrequest();
                handler.postDelayed(this, 6000);//60 second delay
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    private String getDate(long timeStamp) {
        try {
            DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx";
        }
    }


    }