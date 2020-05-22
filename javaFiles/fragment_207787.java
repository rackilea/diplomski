int count = spark.parallelize(makeRange(1, NUM_SAMPLES)).filter(new Function<Integer, Boolean>() {
  public Integer call(Integer i) {
    double x = Math.random();
    double y = Math.random();
    return x*x + y*y < 1;
  }
}).count();
System.out.println("Pi is roughly " + 4 * count / NUM_SAMPLES);