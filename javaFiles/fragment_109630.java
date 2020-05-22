public static void main(String[] args) throws JSONException {

        String s="{\"period\":\"\",\"billing_mode\":\"checked\",\"price\":\"1500\",\"packageid\":0,\"name\":\"hello stack\",\"subscriberid\":\"9283is3j4\",\"date\":\"2016-06-23\",\"serviceid\":0,\"type\":\"event\",\"programid\":999}";

        JSONObject jsonObj = new JSONObject(s);

        JSONArray nameArray = jsonObj.names();

        List<String> keyList = new ArrayList<String>();
        for (int i = 0; i < nameArray.length(); i++) {
            keyList.add(nameArray.get(i).toString());
        }

            for (String key : keyList) {
                if (jsonObj.get(key).equals("")) 
                {
                    jsonObj.remove(key);
                }
            }

        System.out.println(jsonObj.toString());
    }