public static void main(String[] args) {

// Create spark session
   SparkSession session = SparkSession.builder().appName("[Spark app sql version]").getOrCreate();

   Dataset<MovieRatings> personsDataframe = session.read()
                .format("tct")
                .option("header", false)
                .option("inferSchema", true)
                .option("delimiter", "\\s+")
                .load("u.data.txt")
                .map(row -> {
                   int movieID = row.getInteger(0);
                   int rating = row.getInteger(1);
                   return new MovieRatings(movieID, rating);
                 }).as(Encoders.bean(MovieRatings.class);

      // Stop session
         session.stop();

  }

  }