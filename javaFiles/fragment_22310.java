public static void main(String[] args) {
    BigDecimal big = new BigDecimal("1234567.5555");
    DummyPojo summary = new DummyPojo();
    JsonObject resultJson = new JsonObject(); //this is Gson not Java EE 7
    summary.setId("A001");
    summary.setAmount(big);
    resultJson.addProperty("summary", new Gson().toJson(summary));
    System.out.println(resultJson.toString());
    //Outputs: {"summary":"{\"amount\":1234567.5555,\"id\":\"A001\"}"}
}