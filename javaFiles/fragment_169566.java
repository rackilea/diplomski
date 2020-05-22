public final class RandomInteger {
  private Random randomGenerator = new Random(); //A single object can reuse this component

  //function prints out x random numbers between low and high
  //Note that your function should do ONE thing, therefore do not make it also interpret
  //your program arguments!
  public void logXRandomNumbers(int x, int low, int high){ 
    log("Generating " + x + " random integers in range " + low ".." + high);

    int range = high - low;
    //you really should do a sanity check here to ensure the range is valid.

    //note a single Random object is reused here
    for (int idx = 1; idx <= x; ++idx){
      int nextResult = this.randomGenerator.nextInt(range) + low;
      log("Generated : " + nextResult);
    }

    log("Done.");
  }

  //This function is probably overkill
  private static void log(String aMessage){
    System.out.println(aMessage);
  }
}