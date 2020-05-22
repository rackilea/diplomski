package com.jamp.jamp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Erikken on 05.09.2017.
 */

public class UserProfileSettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener
{
    SessionManager session;
    Context mContext;

    String prefs_realname;
    String prefs_email;
    String prefs_streetname;
    String prefs_postcode;
    String prefs_city;
    String prefs_state;

    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        final SharedPreferences.Editor editor = prefs.edit();
        prefs.registerOnSharedPreferenceChangeListener(this);
        mContext = getActivity().getApplicationContext();

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.usersettings);

        session = new SessionManager(getActivity().getApplicationContext());
        session.CheckLogin();

        HashMap<String,String> user = session.getUserDetails();
        final String sessionUsername = user.get(SessionManager.KEY_USERNAME);
        final String sessionPassword = user.get(SessionManager.KEY_PASSWORD);

        // ResponseListener um Request Nutzerdaten auszulesen.
        Response.Listener<String> UserDataResponseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    // Wenn Datenabfrage erfolgreich, JSONResponse auswerten. // If successful, import data from mysql database
                    if (success) {
                        String responseRealName   = jsonResponse.getString("realname");     if (responseRealName.equals(""))   {responseRealName = getResources().getString(R.string.MissingRealName);}
                        String responseEmail      = jsonResponse.getString("email");        if (responseEmail.equals(""))      {responseEmail= getResources().getString(R.string.MissingEmail);}
                        String responseStreetName = jsonResponse.getString("streetname");   if (responseStreetName.equals("")) {responseStreetName = getResources().getString(R.string.MissingStreetName);}
                        String responsePostcode   = jsonResponse.getString("postcode");     if (responsePostcode.equals(""))   {responsePostcode = getResources().getString(R.string.MissingPostcode);}
                        String responseCity       = jsonResponse.getString("city");         if (responseCity.equals(""))       {responseCity = getResources().getString(R.string.MissingCity);}
                        String responseState      = jsonResponse.getString("state");        if (responseState.equals(""))      {responseState = getResources().getString(R.string.MissingState);}
                        int    responseAge        = jsonResponse.getInt   ("age");
                        int    responseIsPremium  = jsonResponse.getInt   ("isPremium"); // BOOLEAN

                        // Add data to shared prefs
                        editor.putString("realname",responseRealName);
                        editor.putString("email",responseEmail);
                        editor.putString("streetname",responseStreetName);
                        editor.putString("postcode",responsePostcode);
                        editor.putString("city",responseCity);
                        editor.putString("state",responseState);
                        editor.commit();

                        prefs_realname = prefs.getString("realname","0");
                        prefs_email = prefs.getString("email","0");
                        prefs_streetname = prefs.getString("streetname","0");
                        prefs_postcode = prefs.getString("postcode","0");
                        prefs_city = prefs.getString("city","0");
                        prefs_state = prefs.getString("state","0");

                        Preference prefUserData = (Preference) findPreference("preferencescreen_userdata");
                        prefUserData.setTitle(sessionUsername);
                        prefUserData.setSummary(prefs_realname+"\n"
                                                +prefs_email+"\n"
                                                +prefs_streetname+"\n"
                                                +prefs_postcode + " " + prefs_city +"\n"
                                                +prefs_state);

                        findPreference("settings_username").setTitle(sessionUsername);
                        findPreference("settings_realname").setSummary(prefs_realname);
                        findPreference("settings_email").setSummary(prefs_email);
                        findPreference("settings_streetname").setSummary(prefs_streetname);
                        findPreference("settings_postcode").setSummary(prefs_postcode);
                        findPreference("settings_city").setSummary(prefs_city);
                        findPreference("settings_state").setSummary(prefs_state);


                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Konnte Nutzerdaten nicht abrufen.")
                                .setNegativeButton("Nochmal",null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        };
        // Request an userdatarequest.php senden / Send request to userdatarequest.php
        UserDataRequest userDataRequest = new UserDataRequest(sessionUsername, UserDataResponseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(userDataRequest);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        session = new SessionManager(mContext);
        HashMap<String,String> user = session.getUserDetails();
        final String sessionUsername = user.get(SessionManager.KEY_USERNAME);
        final String sessionPassword = user.get(SessionManager.KEY_PASSWORD);

        Response.Listener<String> UpdateUserDataResponseListener = new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success){
                        Toast.makeText(mContext,"Change Successful",Toast.LENGTH_LONG).show();
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setMessage("Konnte Nutzerdaten nicht abrufen.")
                                .setNegativeButton("Nochmal",null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        };

        if (key.equals("settings_email")){ // Adressenprüfung mussnoch implementiert werden.
            // An mySQLDB senden
                                                                                                  //CELLNAME                           // CELLVALUE
                     UpdateUserDataRequest updateUserDataRequest = new UpdateUserDataRequest(sessionUsername, sessionPassword, "email", sharedPreferences.getString(key, ""), UpdateUserDataResponseListener);
                     RequestQueue queue = Volley.newRequestQueue(mContext);
                     queue.add(updateUserDataRequest);
                     // Summary sofort erneuern. // Refresh Summaries instantly
                     prefs_email = sharedPreferences.getString(key, "");
                     findPreference(key).setSummary(prefs_email);
                     findPreference("preferencescreen_userdata").setSummary(prefs_realname + "\n"
                             + prefs_email + "\n"
                             + prefs_streetname + "\n"
                             + prefs_postcode + " " + prefs_city + "\n"
                             + prefs_state);

        }

        if (key.equals("settings_streetname")){
            UpdateUserDataRequest updateUserDataRequest = new UpdateUserDataRequest(sessionUsername,sessionPassword,"streetname",sharedPreferences.getString(key,""), UpdateUserDataResponseListener);
            RequestQueue queue = Volley.newRequestQueue(mContext);
            queue.add(updateUserDataRequest);
            // Summary sofort erneuern. // Refresh Summaries instantly
            prefs_streetname = sharedPreferences.getString(key,"");
            findPreference(key).setSummary(prefs_streetname);
            findPreference("preferencescreen_userdata").setSummary(prefs_realname+"\n"
                    +prefs_email+"\n"
                    +prefs_streetname+"\n"
                    +prefs_postcode + " " + prefs_city +"\n"
                    +prefs_state);
        }

        if (key.equals("settings_realname")){
            UpdateUserDataRequest updateUserDataRequest = new UpdateUserDataRequest(sessionUsername,sessionPassword,"realname",sharedPreferences.getString(key,""), UpdateUserDataResponseListener);
            RequestQueue queue = Volley.newRequestQueue(mContext);
            queue.add(updateUserDataRequest);
            // Summary sofort erneuern. // Refresh Summaries instantly
            prefs_realname = sharedPreferences.getString(key,"");
            findPreference(key).setSummary(prefs_realname);
            findPreference("preferencescreen_userdata").setSummary(prefs_realname+"\n"
                    +prefs_email+"\n"
                    +prefs_streetname+"\n"
                    +prefs_postcode + " " + prefs_city +"\n"
                    +prefs_state);
        }

        if (key.equals("settings_postcode")){
            UpdateUserDataRequest updateUserDataRequest = new UpdateUserDataRequest(sessionUsername,sessionPassword,"postcode",sharedPreferences.getString(key,""), UpdateUserDataResponseListener);
            RequestQueue queue = Volley.newRequestQueue(mContext);
            queue.add(updateUserDataRequest);
            // Summary sofort erneuern. // Refresh Summaries instantly
            prefs_postcode = sharedPreferences.getString(key,"");
            findPreference(key).setSummary(prefs_postcode);
            findPreference("preferencescreen_userdata").setSummary(prefs_realname+"\n"
                    +prefs_email+"\n"
                    +prefs_streetname+"\n"
                    +prefs_postcode + " " + prefs_city +"\n"
                    +prefs_state);
        }

        if (key.equals("settings_city")) {
            UpdateUserDataRequest updateUserDataRequest = new UpdateUserDataRequest(sessionUsername,sessionPassword,"city",sharedPreferences.getString(key,""), UpdateUserDataResponseListener);
            RequestQueue queue = Volley.newRequestQueue(mContext);
            queue.add(updateUserDataRequest);
            // Summary sofort erneuern. // Refresh Summaries instantly
            prefs_city = sharedPreferences.getString(key,"");
            findPreference(key).setSummary(prefs_city);
            findPreference("preferencescreen_userdata").setSummary(prefs_realname+"\n"
                    +prefs_email+"\n"
                    +prefs_streetname+"\n"
                    +prefs_postcode + " " + prefs_city +"\n"
                    +prefs_state);
        }
        if (key.equals("settings_state")) {
            UpdateUserDataRequest updateUserDataRequest = new UpdateUserDataRequest(sessionUsername,sessionPassword,"state",sharedPreferences.getString(key,""), UpdateUserDataResponseListener);
            RequestQueue queue = Volley.newRequestQueue(mContext);
            queue.add(updateUserDataRequest);
            // Summary sofort erneuern. // Refresh Summaries instantly
            prefs_state = sharedPreferences.getString(key,"");
            findPreference(key).setSummary(prefs_state);
            findPreference("preferencescreen_userdata").setSummary(prefs_realname+"\n"
                    +prefs_email+"\n"
                    +prefs_streetname+"\n"
                    +prefs_postcode + " " + prefs_city +"\n"
                    +prefs_state);
        }
    }
}