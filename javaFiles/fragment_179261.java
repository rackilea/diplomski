public class MutableInt

private int i;
public MutableInt(int i) {
  set(i);
}

public int get() {
  return i;
}

public void set(int i) {
  this.i = i;
}

public void increment() {
  i++;
}

// more stuff if you want to