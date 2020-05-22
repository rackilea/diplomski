public class PhoneDirectory {
  private final Set<Integer> available = new HashSet<Integer>();
  private final int maxNumbers;
  private int largestOffered;

  public PhoneDirectory(int maxNumbers) {
    this.maxNumbers = maxNumbers;
    this.largestOffered = 0;
  }

  public int get() {
    if (available.isEmpty()) {
      return largestOffered < maxNumbers ? (++largestOffered) : -1;
    }
    int result = available.iterator().next();
    available.remove(result);
    return result;
  }

  public boolean check(int number) {
    return available.contains(number) || number > largestOffered;
  }

  public void release(int number) {
    available.add(number);
  }
}