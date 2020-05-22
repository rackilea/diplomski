public void map(
    IntWritable key,  // your key type
    Text value,       // your value type
    Context context
)
{
    // ...

    String rowsSerialized = context.getConfiguration().get("CassandraRows");
    String[] rows = deserializeRows(rowsSerialized);  // TODO: implement deserializer

    //...
}