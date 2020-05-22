public class User implements Comparable<User> {
  private int mId;
  private String mName;

  public User(final int id, final String name) {
    mId = id;
    mString = name;
  }

  public String getName() {
    return mName;
  }

  @Override
  public int compare(final User lhs, final User rhs) {
    return Integer.compare(lhs.mId, rhs.mId);
  }

  @Override
  public String toString() {
    return String.format("%s #%d", mName, mId);
  }
}