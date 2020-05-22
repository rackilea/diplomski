public void map(
    IntWritable key,  // your key type
    Text value,       // your value type
    Context context
)
{
    // ...

    URI[] cacheFiles = context.getCacheFiles();

    // find, open and read your file here

    // ...
}