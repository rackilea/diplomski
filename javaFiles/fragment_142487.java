Arrays.sort(array, new CustomComparator());

public class CustomComparator implements Comparator<String> {
  private final Pattern pattern = Pattern.compile("(\\d+)\\s+(.*)");

  public int compare(String s1, String s2) {
    Matcher m1 = pattern.matcher(s1);
    if (!m1.matches()) {
      throw new IllegalArgumentException("s1 doesn't match: " + s1);
    }
    Matcher m2 = pattern.matcher(s2);
    if (!m2.matches()) {
      throw new IllegalArgumentException("s2 doesn't match: " + s2);
    }
    int i1 = Integer.parseInt(m1.group(1));
    int i2 = Integer.parseInt(m2.group(1));
    if (i1 < i2) {
      return 1;
    } else if (i1 > i2) {
      return -1;
    }
    return m1.group(2).compareTo(m2.group(2));
  }
}