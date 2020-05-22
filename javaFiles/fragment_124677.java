package sathyabamanan.com.duoproject.comman;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by baman on 6/25/17.
 */

  public class RequestExternalResouce extends AsyncTask<String, Void, String> {

    private Context mContext;
    private OnTaskDoneListener onTaskDoneListener;
    private String urlStr = "";
    private String  requestBody = "";

    public RequestExternalResouce(Context context, String url, String body, OnTaskDoneListener onTaskDoneListener) {
        this.mContext = context;
        this.urlStr = url;
        this.requestBody= body;
        this.onTaskDoneListener = onTaskDoneListener;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL mUrl = new URL(urlStr);
            HttpURLConnection httpConnection = (HttpURLConnection) mUrl.openConnection();
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpConnection.setUseCaches(false);
            httpConnection.setAllowUserInteraction(false);
            httpConnection.setConnectTimeout(1000000);
            httpConnection.setReadTimeout(1000000);
            httpConnection.setDoOutput(true);


            DataOutputStream localDataOutputStream = new DataOutputStream(httpConnection.getOutputStream());
            localDataOutputStream.writeBytes(requestBody.toString());
            localDataOutputStream.flush();
            localDataOutputStream.close();


            int responseCode = httpConnection.getResponseCode();
            httpConnection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();



            if (responseCode == HttpURLConnection.HTTP_OK) {
                return sb.toString();
            }

        } catch (IOException e) { e.printStackTrace();
        } catch (Exception ex) { ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (onTaskDoneListener != null && s != null) {
            onTaskDoneListener.onTaskDone(s);
        } else
            onTaskDoneListener.onError();
    }


    public interface OnTaskDoneListener {
        void onTaskDone(String responseData);
        void onError();
    }

}