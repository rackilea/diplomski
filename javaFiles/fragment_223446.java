JavaRDD<Url> urlsRDD = spark.read()
  .textFile("/Users/karuturi/Downloads/log.txt")
  .javaRDD()
  .map(new Function<String, Url>() {
    @Override
    public Url call(String line) throws Exception {
      String[] parts = line.split("\\t");
      Url url = new Url();
      url.setValue(parts[0].replaceAll("[", ""));
      return url;
    }
  });