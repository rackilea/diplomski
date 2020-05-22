private String parseJson(String source) {
    JSONArray result = new JSONArray();
    List<Integer> ids = new ArrayList<>();
    HashMap<Integer,JSONObject> programs = new HashMap<>();
    try {
        JSONObject jSource = new JSONObject(source);
        JSONArray orderDetails = jSource.getJSONArray("order_details");
        if (orderDetails.length() > 0) {
            for (int i = 0; i < orderDetails.length(); i++) {
                JSONObject jsonObject = orderDetails.getJSONObject(i);
                JSONObject item = jsonObject.getJSONObject("item");
                JSONObject program = jsonObject.getJSONObject("program");
                int programId = jsonObject.getJSONObject("program").getInt("id");
                if (!ids.contains(programId)) {
                    ids.add(programId);
                    program.put("item",new JSONArray().put(item));
                    programs.put(programId,program);
                }else{
                    program.put("item",programs.get(programId).getJSONArray("item").put(item));
                }
            }

            for(int k :programs.keySet()){
                result.put(programs.get(k));
            }

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return result.toString();
}