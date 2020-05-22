public static long parallelSum(long n){
   return Stream.iterate(1L, i -> i + 1) // generate a stream of long values, starting at 1
                .limit(n) // limit the stream to n items
                .parallel()
                .reduce(0L, Long::sum); // this is what we want to execute concurrently, and in the end the result of each sub-stream will be combined using this sum
}