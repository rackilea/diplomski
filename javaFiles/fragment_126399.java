JavaSparkContext jsc = new JavaSparkContext(sc);
  JavaPairRDD<String,String> rdd = jsc.wholeTextFiles(path);
          for(Tuple2<String, String> str : rdd.toArray()) {           System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
      System.out.println("File name " + str._1);
      System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
      System.out.println();
      System.out.println("-------------------------------------------");
      System.out.println("content " + str._2);
      System.out.println("-------------------------------------------");
  }