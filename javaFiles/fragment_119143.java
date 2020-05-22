public class JSONParser{
private Context context;

public JSONParser(Context context){
   this.context =  context;
}

ArrayList<HashMap<String, String>> userList;

public String loadJSONFromAsset() {
    String json = null;
    try {
        InputStream is = context.getAssets().open("users.json");

        int size = is.available();

        byte[] buffer = new byte[size];

        is.read(buffer);

        is.close();

        json = new String(buffer, "UTF-8");

    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return json;

}

public JSONObject parseJson() {

    //ArrayList<HashMap<String, String>> userList
    try {

        JSONObject reader = new 
       JSONObject(String.valueOf(loadJSONFromAsset()));

        JSONArray users = reader.getJSONArray("users");
        Log.d("AnzahlUser", String.valueOf(users.length()));

        for (int i = 0; i < users.length(); i++) {
            JSONObject u = users.getJSONObject(i);
            Log.d("Details-->", u.toString());
            String uid = u.getString("uid");
            String uname = u.getString("uname");
            String ustart = u.getString("ustart");
            //String uend = u.getString("u.end");

            HashMap<String, String> user = new HashMap<>();

            user.put("uid", uid);
            user.put("uname", uname);
            user.put("ustart", ustart);
            //user.put("u.end", uend);

            userList.add(user);




        }
    } catch (final JSONException e) {
        e.printStackTrace();
    }

    return null;
    }
}