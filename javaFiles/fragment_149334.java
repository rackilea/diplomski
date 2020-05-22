// Read a file containing the Stock Quotations
// You can also paralelize a collection of objects to create a RDD
JavaRDD<String> linesRDD = sc.textFile("some sample file containing stock prices");

// Convert the lines into our business objects
JavaRDD<StockQuotation> quotationsRDD = linesRDD.flatMap(new ConvertLineToStockQuotation());

// We need these two objects in order to use the MLLib RDDFunctions object
ClassTag<StockQuotation> classTag = scala.reflect.ClassManifestFactory.fromClass(StockQuotation.class);
RDD<StockQuotation> rdd = JavaRDD.toRDD(quotationsRDD);

// Instantiate a RDDFunctions object to work with
RDDFunctions<StockQuotation> rddFs = RDDFunctions.fromRDD(rdd, classTag);

// This applies the sliding function and return the (DATE,SMA) tuple
JavaPairRDD<Date, Double> smaPerDate =     rddFs.sliding(slidingWindow).toJavaRDD().mapToPair(new MovingAvgByDateFunction());
List<Tuple2<Date, Double>> smaPerDateList = smaPerDate.collect();