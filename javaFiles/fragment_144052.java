public abstract class Reporting {
  public void setUp(Job job) {
    // set things up
  }

  public void tearDown(Job job) {
    // post-processing stuff
  }

  public void process(Job job) {
    setUp(job);
    doProcessing(job);
    tearDown(job);
  }

  public abstract void doProcessing(Job job);
}

public class Processor1 extends Reporting {
  @Override
  public void doProcessing(Job job) {
    // business logic
  }
}