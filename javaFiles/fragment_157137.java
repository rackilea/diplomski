package com.nct.dhruv.demotest;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by user31 on 4/12/17.
 */

public class AppEventLogger {

    private Context mContext;
    private String appContextName = "AppEventLogger";

    public AppEventLogger(Context context) {
        mContext = context;
        Loginlog(1, true, 11, 112, 121, 12);
        Logoutlog(2, false);

    }

    //private static final String TAG = AppEventsLogger.class.getCanonicalName();
    JSONArray jsonArray = new JSONArray();

    public void Loginlog(long id, boolean result, int failedattempts, int attempts, long eventTime, long mLastInteractionTime) {
        eventTime = System.currentTimeMillis();

        createJson(appContextName , " ID : " + id + " Result : " + result + " failedattempts : " + failedattempts + " attempts : " + attempts + " eventTime : " + " mLastInteractionTime : " + mLastInteractionTime);

                    /*logLogin(id,
                    result,
                    failedattempts,
                    attempts,
                    eventTime,
                    mLastInteractionTime);*/


    }


    public void Logoutlog(long eventTime, boolean isLoggedOut) {
        eventTime = System.currentTimeMillis();

        createJson(appContextName, " eventTime : " + eventTime + " isLoggedOut : " + isLoggedOut);

    }


    private void createJson(String context, String logData) {
        try {
            Log.d("data", logData);


            JSONObject jsonObjOne = new JSONObject();
            jsonObjOne.put("context", context);
            jsonObjOne.put("logData", logData);


            jsonArray.put(jsonObjOne);

            JSONObject json = new JSONObject();
            json.put("JsonData", jsonArray);

           // Log.e("Your_JSON", json.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}