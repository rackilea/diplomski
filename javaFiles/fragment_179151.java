package com.example.mjla;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class BikeSelection extends Activity {

    ListView lv;
    ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();
    private static final String LOGIN_URL = "http://192.168.231.2/bikeSelection.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    Map<String,Object> abc = new HashMap<String,Object>();

    int[] imagesBike = {};
    String[] namesBike = {};
    String[] brandsBike = {};
    String[] typesBike = {};
    String[] avgsBike = {};
    String[] ratingsBike = {};
    String[] idBike = {};
    String[] descriptionBike = {};
    String[] availableCity = {};
    String[] availabilityBike = {};
    String[] pricekmBike = {};
    String[] pricedayBike = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_selection);

        try{
            lv = (ListView) findViewById(R.id.listViewId);

            new FetchingBikeData().execute();

        }
        catch(Exception e)
        {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            Log.d("exception",errors.toString());
        }
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), namesBike[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateList() {
        if(abc.get("size") != null)
        {
            int size = (Integer) abc.get("size");
            imagesBike = new int[size];
            namesBike = new String[size];
            brandsBike = new String[size];
            typesBike = new String[size];
            avgsBike = new String[size];
            ratingsBike = new String[size];
            idBike = new String[size];
            descriptionBike = new String[size];
            availableCity = new String[size];
            availabilityBike = new String[size];
            pricekmBike = new String[size];
            pricedayBike = new String[size];


            if(abc.get("imagesBike")!=null && abc.get("namesBike")!=null && abc.get("brandsBike")!=null && abc.get("typesBike")!=null && abc.get("avgsBike")!=null && abc.get("ratingsBike")!=null && abc.get("idBike")!=null && abc.get("descriptionBike")!=null && abc.get("availableCity")!=null && abc.get("availabilityBike")!=null && abc.get("pricekmBike")!=null && abc.get("pricedayBike")!=null) {
                this.imagesBike = (int[]) abc.get("imagesBike");
                this.namesBike =  (String[]) abc.get("namesBike");
                this.brandsBike = (String[]) abc.get("brandsBike");
                this.typesBike =  (String[]) abc.get("typesBike");
                this.avgsBike = (String[]) abc.get("avgsBike");
                this.ratingsBike =  (String[]) abc.get("ratingsBike");
                this.idBike =  (String[]) abc.get("idBike");
                this.descriptionBike = (String[]) abc.get("descriptionBike");
                this.availableCity =  (String[]) abc.get("availableCity");
                this.availabilityBike = (String[]) abc.get("availabilityBike");
                this.pricekmBike =  (String[]) abc.get("pricekmBike");
                this.pricedayBike =  (String[]) abc.get("pricedayBike");
            }
        }

        Log.d("final", namesBike[1]);
        //ADAPTER
        AdapterBike adapter = new AdapterBike(this, imagesBike, namesBike, brandsBike, typesBike, avgsBike, ratingsBike, idBike, descriptionBike, availableCity, availabilityBike, pricekmBike, pricedayBike);
        lv.setAdapter(adapter);
        Log.d("final", namesBike[1]);
    }

    class FetchingBikeData extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(BikeSelection.this);
            pDialog.setMessage("fetching bike data");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            int success;
            String query = "select * from tblbike";

            try {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("query", query));

                Log.d("request!", "starting");

                JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params);

                // checking  log for json response
                Log.d("query Executed", json.toString());

                JSONArray jsonArray = json.getJSONArray("bikes");


                int size = jsonArray.length();
                imagesBike = new int[size];
                namesBike = new String[size];
                brandsBike = new String[size];
                typesBike = new String[size];
                avgsBike = new String[size];
                ratingsBike = new String[size];
                idBike = new String[size];
                descriptionBike = new String[size];
                availableCity = new String[size];
                availabilityBike = new String[size];
                pricekmBike = new String[size];
                pricedayBike = new String[size];

                for(int i = 0; i<jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    namesBike[i] = jsonObject.getString("bike_name");
                    imagesBike[i] = getResources().getIdentifier(namesBike[i], "drawable", getPackageName());
                    brandsBike[i] = jsonObject.getString("bike_brand");
                    typesBike[i] = jsonObject.getString("bike_type");
                    avgsBike[i] = jsonObject.getString("bike_avg");
                    ratingsBike[i] = jsonObject.getString("rating");
                    idBike[i] = jsonObject.getString("bike_id");
                    descriptionBike[i] = jsonObject.getString("description");
                    availableCity[i] = jsonObject.getString("available_city");
                    availabilityBike[i] = jsonObject.getString("availability");
                    pricekmBike[i] = jsonObject.getString("pricekm");
                    pricedayBike[i] = jsonObject.getString("priceday");


                    Log.d("Bike Name Fteched", namesBike[i]);
                    Log.d("Bike Image",""+imagesBike[i]) ;


                }

                abc.put("size", size);
                abc.put("imagesBike", imagesBike);
                abc.put("namesBike", namesBike);
                abc.put("brandsBike", brandsBike);
                abc.put("typesBike", typesBike);
                abc.put("avgsBike", avgsBike);
                abc.put("ratingsBike", ratingsBike);
                abc.put("idBike", idBike);
                abc.put("descriptionBike", descriptionBike);
                abc.put("availableCity", availableCity);
                abc.put("availabilityBike", availabilityBike);
                abc.put("pricekmBike", pricekmBike);
                abc.put("pricedayBike", pricedayBike);

                // success tag for json
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("Successfully Data fetched!", json.toString());

                    return json.getString(TAG_MESSAGE);
                }else{
                    return json.getString(TAG_MESSAGE);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String message) {
            pDialog.dismiss();
            if (message != null){
                Toast.makeText(BikeSelection.this, message, Toast.LENGTH_LONG).show();
                updateList()
            }
        }
    }

}