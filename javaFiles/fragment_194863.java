public class Job implements Comparable<Job> { // a job is comparable to another job
  private String path;
  private List<String> targets;
  private final int order;
  public Job(String path, int order, List<String> targets) {
    this.path = path;
    this.order = order;
    this.targets = targets;
  }
  public int compareTo(Job j) {
    return this.order - j.order; // here you specify how you want your jobs sorted
  }
}