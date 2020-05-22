public interface IntegerStack {
  void push(int e);
  int pop();
  int peek();
  boolean isEmpty();
  int size();
  void print();
}

public class ArrayIntegerStack implements IntegerStack {
  private static final int INITIAL_TOP_INDEX = -1;

  private int topIndex = INITIAL_TOP_INDEX;
  private int[] stackValue = new int[Integer.MAX_VALUE];

  @Override
  public void push(int element) {
    stackValue[++topIndex] = element;
  }

  @Override
  public int pop() {
    return stackValue[topIndex--];
  }

  @Override
  public int peek() {
    return stackValue[topIndex];
  }

  @Override
  public boolean isEmpty() {
    return INITIAL_TOP_INDEX == topIndex;
  }

  @Override
  public int size() {
    return topIndex + 1;
  }

  @Override
  public void print() {
    for (int i = 0; i <= topIndex; i++) {
      System.out.println(stackValue[i]);
    }
  }
}