String firstData = "[[0.11492168, -0.30645782, 9.835381], [0.12449849, -0.29688102, 9.844957]]";
Gson gson = new Gson();
List<List<Float>> firstList = gson.fromJson(firstData, new TypeToken<List<List<Float>>>() {}.getType());

System.out.println(firstList);
// prints [[0.11492168, -0.30645782, 9.835381], [0.12449849, -0.29688102, 9.844957]]