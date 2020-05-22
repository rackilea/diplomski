String appName = UUID.randomUUID().toString();
SparkConf sc = new SparkConf().setAppName(appName).setMaster("local");
JavaSparkContext jsc = new JavaSparkContext(sc);

JavaPairRDD<String, String> fS = jsc.wholeTextFiles("tmp");

System.out.println("File names:");
fS.keys().collect().forEach(new Consumer<String>(){
    public void accept(String t)
    {
        System.out.println(t);
    }});

System.out.println("File content:");
fS.values().collect().forEach(new Consumer<String>(){
    public void accept(String t)
    {
        System.out.println(t);
    }});    
jsc.close();