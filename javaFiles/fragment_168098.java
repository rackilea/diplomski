public static class Driver extends Configured implements Tool {
  public static void main(String[] args) throws Exception {
    System.exit(ToolRunner.run(new Driver(), args));
  }

  public int run(String args[]) {
    if (args.length != 2) {
      System.err.println("Usage: indycascade <in> <out>");
      System.exit(2);
    }

    Job job = new Job(getConf());
    Configuration conf = job.getConfiguration();

    // insert other job set up here

    return job.waitForCompletion(true) ? 0 : 1;
  }
}