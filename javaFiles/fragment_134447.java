public static void main(String[] args) throws IOException {
    String jsondata = "{\"columns\" : [\"Book\", \"Publisher\" ],    \"data\" : [ [ \"Book1\", \"Author1\" ], [ \"Book2\", \"Author2\" ], [ \"Book3\", \"Author3\" ]]}";
    JSONObject obj = (JSONObject)JSONValue.parse(jsondata);         
    JSONArray jsonval= (JSONArray)obj.get("data");
    HashMap<String, String> map = new HashMap<String, String>();

    for (int i=0; i<jsonval.toArray().length; i++) {
        JSONArray datapair = (JSONArray)jsonval.get(i);
        String book = (String) datapair.get(0);
        String author = (String)datapair.get(1);
        map.put(book, author);
    }
}