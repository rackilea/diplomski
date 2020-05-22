public static void main(String[] args) {
    String response = "[{  \"apicall1\":      [{      \"thisField\":\"thisFieldData\",      \"thatField\":\"thatFieldData\",      \"anotherField\":\"anotherFieldData\"     }]}]";
    Gson gson = new Gson();
    List<Response> responses = gson.fromJson(response, new TypeToken<List<Response>>(){}.getType());
    System.out.println(responses.get(0).getApicall1().get(0).getThisField());
}