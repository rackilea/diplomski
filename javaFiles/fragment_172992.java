@Override
public void onMessageReceived(String from, Bundle data) {

    String myJSONString = data.getString("myJSON");

    JSONObject myJson = new JSONObject(myJSONString);

    int registration_id = myJson.optInt("registration_id ");
    String time_to_live = myJson.optString("time_to_live");
}