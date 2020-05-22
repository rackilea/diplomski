public static class IntSumReducer extends Reducer<Text, Text, Text, Text> {
private Text result = new Text();
public void reduce(Text key, Iterable<Text> values, Context context) 
    throws IOException, InterruptedException {
    System.out.println("This is Red Value ");
    int sum = 0;
    int budget = 0;
    float avgBudget = 0;
    System.out.println("This is Reducer Jobs");
    for (Text val : values) {
        String value[] = val.toString().split(",");
        System.out.println("This is Reduce Value " + value);
        sum = sum + Integer.parseInt(value[0]);
        budget = budget + Integer.parseInt(value[2]);
    }
    avgBudget = budget / sum;
    result.set(sum + " " + avgBudget);
    context.write(key, result);
}}