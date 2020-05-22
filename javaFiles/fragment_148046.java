public class Fetch  extends AsyncTask<Void,Void,String[][]> {
    public static int KEY = 0;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
     protected String[][] doInBackground(Void... voids) {
          HttpHandler sh = new HttpHandler();
           String url = "http:xxxxxxx/xxx.json";
           String jsonStr = sh.makeServiceCall(url);
           JSONObject jsonObj = null;
            try {
                jsonObj = new JSONObject(jsonStr);
                int nTiempos=jsonObj.length();
                String[] IdKeyArray = new String[nTie];
        for (int i = 0; i < jsonObj.length(); i++) {
                  JSONObject c = jsonObj.getJSONObject(String.valueOf(i));
                  IdKeyArray[i] = c.getString("Key");
                  String[][] valores={IdKeyArray};
                return valores;
            } catch (JSONException e) {
            e.printStackTrace();
        }
       return null;
   }
}