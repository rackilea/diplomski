public void map(Object key, Text value, Context context) {
    String[] row = value.toString().split(";");
    String city = row[0].split("&")[0];
    String product = row[0].split("&")[1];
    String count = row[1];
    context.write(new Text(city), new Text(product + "&" + count));     
}