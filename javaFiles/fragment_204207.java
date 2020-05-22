public interface CloneableTestInput<T extends CloneableTestInput<T>> extends Cloneable {
  T clone();
}

public class CloneableString implements CloneableTestInput<CloneableString> {
  public String data;
  public CloneableString() {}
  public CloneableString(String input) { data = input; }

  public CloneableString clone() { return new CloneableString(String.valueOf(data)); }
}

public class CloneableArrayList extends ArrayList implements CloneableTestInput<CloneableArrayList> {
  public CloneableArrayList(ArrayList input) {
    this.addAll(input);
  }

  @Override
  public CloneableArrayList clone() {
    return new CloneableArrayList(this);
  }
}