public void settexttotextview(JSONArray jsonArray) {

    List<List<String>> list = new ArrayList<List<String>>();
    List<String> s;
    for(int i=0; i<jsonArray.length();i++){
        JSONObject json=null;
        try {
             s = new ArrayList<String>(); 
             json=jsonArray.getJSONObject(i);
             s.add(json.getString("userid")+json.getString("name")
                      +json.getString("overtime")); 
             list.add(i, s); 
        } catch (Exception e) {
        e.printStackTrace();
        // TODO: handle exception
    }   
}
adapter.add(list); // not sure what adapter is.