public class SparkDriver {

    public static void main (String args[]) {
               // Create a configuration object and set the name of 
               // the application
                  SparkConf conf = new SparkConf().setAppName("application_name");

               // Create a spark Context object
                  JavaSparkContext context = new JavaSparkContext(conf);

              // Create final rdd (suppose you have a text file)
                 JavaPairRDD<Integer,Integer> movieRatingRDD = 
                            contextFile("u.data.txt")
                            .mapToPair(line -> {(
                                String[] tokens = line.split("\\s+");
                                int movieID = Integer.parseInt(tokens[0]);
                                int rating = Integer.parseInt(tokens[1]);
                                return new Tuple2<Integer, Integer>(movieID, rating);});

             // Keep in mind that take operation takes the first n elements
             // and the order is the order of the file.
                ArrayList<Tuple2<Integer, Integer> list = new ArrayList<>(movieRatingRDD.take(10));

                System.out.println("MovieID\tRating");

                for(tuple : list) {
                   System.out.println(tuple._1 + "\t" + tuple._2);
                }

                context.close();
             }}