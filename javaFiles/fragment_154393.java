public static void main(String[] args) throws JSONException {
    String result = "{'header': '[{\"doc_no\": \"DN00001\",\"stage\":\"P\"}]','section':'[{\"upper\":100,\"lower\":1]'}";
    JSONObject json = new JSONObject(result);
    // json now looks like this :-
    //
    if (json != null) {
        String header = json.getString("header");
        System.out.println(header);
    }

}