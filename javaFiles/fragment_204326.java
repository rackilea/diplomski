public void reduce(Text key, Iterable<Text> values, Context context){
    int maxVal = Integer.MIN_VALUE;
    String maxProd = "None";

    for (IntWritable value : values) {
        String ss = value.toString().split("&");
        int cnt = Integer.parseInt(ss[1]);
        if(cnt > maxVal){
            maxVal = cnt;
            maxProd = ss[0];
        }
    }
    context.write(key, new Text(maxProd));
}