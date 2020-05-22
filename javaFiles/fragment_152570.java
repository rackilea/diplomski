public static JSONArray convertToJSON(ResultSet resultSet) throws Exception {
    JSONArray jsonArray = new JSONArray();

    while (resultSet.next()) {
        JSONObject obj = new JSONObject();
        obj.put("startDate" , resultSet.getString('holidays'))
        jsonArray.put(obj);
    }
    return jsonArray;
}