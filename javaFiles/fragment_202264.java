public class PhoneDirectory {
  private final Set<Integer> available = new HashSet<Integer>();

  public PhoneDirectory(int maxNumbers) {
    for (int i = 0; i < maxNumbers; i++) {
      this.available.add(i);
    }
  }

  public int get() {
    if (available.isEmpty()) {
      return -1;
    }
    int result = available.iterator().next();
    available.remove(result);
    return result;
  }

  public boolean check(int number) {
    return available.contains(number);
  }

  public void release(int number) {
    available.add(number);
  }
}