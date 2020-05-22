public void test() {

 String json = "[{\"min\": 0,\"max\": 1209,\"avg\": 1.9203402,\"count\": 7344636,\"sumSq\": 71832774,  \"stddev\": 2.4683187, \"median\": 2,\"percentileMap\": {\"95\": 4},\"metricName\": \"TransactionDuration\",\"dimensions\": {\"env\": \"dev\",\"pool\": \"titan\",\"Name\": \"Client::Sync\", \"Type\": \"Client::Sync\"},\"value\": 14104200}]";

 final Gson gson = new Gson();
 final Type type = new TypeToken<List<DataMetrics>>() {}.getType();
 final List<DataMetrics> records = gson.fromJson(json, type);

 Assert.assertTrue(records.get(0).isClientSync());
}