public class ParseJSON  {

        public static String[] position1;
        public static String[] team;
        public static String[] points;

        public static final String JSON_ARRAY = "data";

        public static final String CHILD_ARRAY = "standings";

        public static final String KEY_ID = "position";
        public static final String KEY_NAME = "team";

        private JSONObject users = null;
        private JSONArray user2=null;
        private JSONObject user3=null;

        private String json;

        public ParseJSON(String json){
            this.json = json;
        }
        protected void parseJSON() {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(json);
                users = jsonObject.getJSONObject(JSON_ARRAY);
                try {
                    user2=users.getJSONArray(CHILD_ARRAY);
                    position1 = new String[user2.length()];
                    team = new String[user2.length()];
                    points=new String[user2.length()];
                    for (int i = 0; i < user2.length(); i++) {

                        JSONObject jo = user2.getJSONObject(i);
                       try {
                           user3=jo.getJSONObject("overall");
                           points[i] = user3.getString("points");
                           System.out.println("Message me: "+points[i]);
                       }catch (Exception e)
                       {
                           e.printStackTrace();
                       }
                        position1[i] = jo.getString(KEY_ID);
                        team[i] = jo.getString(KEY_NAME);
                        System.out.println("Message me: "+position1[i]);
                        System.out.println("Message me: "+team[i]);


                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
             } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }