You are calling Toast in load() function which is in DoInBackground. 
Toast messages touches UI thread which you can't do that.

This line makes it crash.
Toast.makeText(getApplicationContext(), "yaya", Toast.LENGTH_SHORT).show();

Change you load function signature:
This is your function:
private List load() {

don't return a list, create a modal container and return it like:
private ReturnModel load() {

and create a modal like this, and set and get this modal:
and in your load function,fill this returnmodal, set passworderror true or false instead of toast message, and onpostexecute function, check password error and do your toast message there.




package com.nesim.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ChatService extends ListActivity {
  String GotPass;
  String GotUname;
  public static final String PREFS_NAME = "MyPregs";
  private GetTask getTask;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getTask = new GetTask();
    getTask.execute();
  }

  public class GetTask extends AsyncTask<Void, Void, ReturnModel> {
    @Override
    protected ReturnModel doInBackground(Void... params) {
      return load();
    }

    @Override
    protected void onPostExecute(ReturnModel result) {

      if(result.passworderror == true)
      {
        Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
      }
      else
      {
        Toast.makeText(getApplicationContext(), "yaya", Toast.LENGTH_SHORT).show();

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, result.getheadlines());
        setListAdapter(adapter);
      }
    }
  }

  private ReturnModel load() {
    ReturnModel returnModel = new ReturnModel();

    BufferedReader in = null;
    String data = null;
    Bundle gotData = getIntent().getExtras();
    if (gotData != null) {
      GotPass = gotData.getString("key!");
      GotUname = gotData.getString("key!!");
    }

    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    String username = settings.getString("key1", null);
    String password = settings.getString("key2", null);
    // username = "irock97"; // unremark to test like you got username from prefs..
    if (username != null  && username.equals("irock97")) {
      returnModel.setPassworderror(false);
    }
    else 
    {
      returnModel.setPassworderror(true);
      return returnModel;
    }

    HttpClient httpclient = new DefaultHttpClient();

    /* login.php returns true if username and password is equal to saranga */
    HttpPost httppost = new HttpPost("http://gta5news.com/login.php");

    try {
      // Add user name and password
      List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
      nameValuePairs.add(new BasicNameValuePair("username", username));
      nameValuePairs.add(new BasicNameValuePair("password", password));
      httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

      // Execute HTTP Post Request
      Log.w("HttpPost", "Execute HTTP Post Request");
      HttpResponse response = httpclient.execute(httppost);
      in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
      StringBuffer sb = new StringBuffer("");
      String l = "";
      String nl = "";
      while ((l = in.readLine()) != null) {
        sb.append(l + nl);
      }
      in.close();
      data = sb.toString();


      List<String> headlines = new ArrayList<String>();
      headlines.add(data);
      returnModel.setheadlines(headlines);
    }
    catch (ClientProtocolException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return returnModel;
  }


  public class ReturnModel {
    private List<String> headlines;
    private boolean passworderror;

    public List<String> getheadlines() {
      return headlines;
    }

    public void setheadlines(List<String> headlines) {
      this.headlines = headlines;
    }

    public boolean getPassworderror() {
      return passworderror;
    }

    public void setPassworderror(boolean passworderror) {
      this.passworderror = passworderror;
    }
  }

}