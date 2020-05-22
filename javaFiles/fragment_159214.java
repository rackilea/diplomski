public static void main( String[] args )
{
    String jsonObjRecv =  "{\"response\":{\"respobj\":{\"id\":1,\"number\":\"22\",\"validated\":true}},\"status\":\"ok\",\"errors\":null}";

    JsonElement jelement = new JsonParser().parse(jsonObjRecv);
    JsonObject jobject = jelement.getAsJsonObject();

    // Here is where you're making an error. You need to get the outer
    // 'response' object first, then get 'respobj' from that.
    jobject = jobject.getAsJsonObject("response").getAsJsonObject("respobj");

    String result = jobject.get("number").getAsString();

    System.out.println(result);

}