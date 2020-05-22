public class FCMNotification {

// Method to send Notifications from server to client end.
public final static String AUTH_KEY_FCM = "YOUR_SERVERKEY";
public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

public static void pushFCMNotification(final String DeviceIdKey, final String title, final String body) throws Exception {

    AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            BufferedReader in = null;


            String authKey = AUTH_KEY_FCM;   // You FCM AUTH key
            String FMCurl = API_URL_FCM;

            URL url = null;
            try {
                url = new URL(FMCurl);
            } catch (MalformedURLException e) {
                Log.i("yoyoyo", "error: 1");
                e.printStackTrace();
            }
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                Log.i("yoyoyo", "error: 2");
                e.printStackTrace();
            }

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            try {
                conn.setRequestMethod("POST");
            } catch (ProtocolException e) {
                Log.i("yoyoyo", "error: 3");
                e.printStackTrace();
            }
            conn.setRequestProperty("Authorization","key="+authKey);
            conn.setRequestProperty("Content-Type","application/json");

            JSONObject json = new JSONObject();
            try {
                json.put("to",DeviceIdKey.trim());
            } catch (JSONException e) {
                Log.i("yoyoyo", "error: 4");
                e.printStackTrace();
            }
            JSONObject info = new JSONObject();
            try {
                info.put("title", title);   // Notification title
            } catch (JSONException e) {
                Log.i("yoyoyo", "error: 5");
                e.printStackTrace();
            }
            try {
                info.put("body", body); // Notification body
            } catch (JSONException e) {
                Log.i("yoyoyo", "error: 6");
                e.printStackTrace();
            }
            try {
                json.put("notification", info);
            } catch (JSONException e) {
                Log.i("yoyoyo", "error: 7");
                e.printStackTrace();
            }

            OutputStreamWriter wr = null;
            try {
                wr = new OutputStreamWriter(conn.getOutputStream());
            } catch (IOException e) {
                Log.i("yoyoyo", "error: 8");
                e.printStackTrace();
            }
            try {
                wr.write(json.toString());
            } catch (IOException e) {
                Log.i("yoyoyo", "error: 9");
                e.printStackTrace();
            }
            try {
                wr.flush();
            } catch (IOException e) {
                Log.i("yoyoyo", "error: 10");
                e.printStackTrace();
            }
            try {
                conn.getInputStream();
            } catch (IOException e) {
                Log.i("yoyoyo", "error: 11");
                e.printStackTrace();
            }

            return null;
        }
    };
    asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);



 }


}