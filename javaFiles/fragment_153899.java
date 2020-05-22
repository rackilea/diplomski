public static void main(String[] args) {
    ... 
    FileInputFormat.setInputPaths(conf, new Path(args[0]));     
    FileOutputFormat.setOutputPath(conf, new Path(args[1]));
    ...
    try {
        DistributedCache.addCacheFile(new URI(args[2]), conf);          
    } catch (URISyntaxException e) {
        System.err.println(e.toString());
    }
    ....
}