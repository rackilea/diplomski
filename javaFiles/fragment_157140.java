/**
 * Created by dhruv on 18/12/17.
 */

public class StringToJson {

    private Context context;

    //Crating constructor
    public StringToJson(Context context) {

        this.context = context;
    }

    public String getJson(String name, String sport, String age, String id, ArrayList lastScores) {

        String result = "";
        JSONObject json = new JSONObject();
        JSONObject mainJson = new JSONObject();
        JSONArray jsonArr = new JSONArray();


        try {


            mainJson.put("name", name);
            mainJson.put("sport", sport);
            mainJson.put("age", age);
            mainJson.put("id", id);

            if (!lastScores.isEmpty()) {

                for (int i = 0; i < lastScores.size(); i++) {
                    jsonArr.put(lastScores.get(i));
                }

            }

            mainJson.put("lastScores", jsonArr);

            json.put("result", mainJson);

            result = json.get("result").toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return result;
    }
}