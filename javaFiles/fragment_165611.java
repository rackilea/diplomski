public static void main(String[] args) {
    String jsonStr = "[{\"value1_1_1\":0},{\"value1_2_2\":0},{\"value1_4_1\":0},{\"value1_5_3\":0},{\"value1_8_3\":0},{\"value1_1_9\":0},{\"value1_2_6\":0},{\"value1_4_1\":0},{\"value1_5_7\":0},{\"value1_8_9\":0},{\"value1_1_1\":0},{\"value1_1_1\":0},{\"value1_2_6\":0},{\"value1_2_6\":0},{\"value1_3_5\":0},{\"value1_3_5\":0},{\"value1_4_2\":0},{\"value1_4_2\":0},{\"value1_8_6\":0},{\"value1_8_6\":0},{\"value1_10_5\":0},{\"value1_10_5\":0}]";

    Map<String, Integer> countMap = new HashMap<>();
    JSONArray jsonArray = new JSONArray(jsonStr);
    for (int i = 0; i < jsonArray.length(); i++) {
        String name = JSONObject.getNames(jsonArray.getJSONObject(i))[0];
        if (countMap.containsKey(name)) {
            countMap.put(name, countMap.get(name)+1);
        } else {
            countMap.put(name, 1);
        }
     }
     System.out.println(countMap.toString());

     JSONArray jsonArrayNew = new JSONArray();
     countMap.forEach((k, v) -> {
         JSONObject jsonObj = new JSONObject();
         jsonArrayNew.put(jsonObj.put(k, v));
     });
     System.out.println(jsonStrNew.toString());
}