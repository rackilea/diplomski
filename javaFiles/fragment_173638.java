public class ClassName extends ParsePushBroadcastReceiver
    {
        String jsonString;
        JSONObject json;`

        protected void onPushReceive(Context mContext, Intent mintent)
        {
            jsonString = mintent.getExtras().getString("com.parse.Data");
            try {
                json = new JSONObject(jsonString);
                System.out.println(json.getString("flag") + " Notification content");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }                                                                                                 
    }