Gson gson = new Gson();
double[][] infos = gson.fromJson(json, double[][].class);
List<TaskBitFinexTrades> result = Lists.newArrayList(); //see: guava
for (double[] info: infos)
    result.add(new TaskBitFinexTrades(info));
for (TaskBitFinexTrades task : result) {
    System.out.println(task);
}