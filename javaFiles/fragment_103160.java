class DoubleStack {
  // Java 7 has its own pair class
  private class Pair<T, U> {
    private T first;
    private U second;
    public Pair(T x, U y) { first = x; second = y; }
    public T getKey() { return first; }
    public U getValue() { return second; }
  }

  private Stack<Pair<Integer, Integer>> redStack = new Stack<>(), blueStack = new Stack<>();
  private int c = 0;

  public boolean empty() {
      return redStack.empty() && blueStack.empty();
  }

  public void pushRed(int x) {
      redStack.push(new Pair<>(x, c++));
  }

  public void pushBlue(int x) {
    blueStack.push(new Pair<>(x, c++));
  }

  public int pop() {
    if (empty()) {
      return Integer.MAX_VALUE; // throw an exception
    } 
    if (redStack.empty()) {
      return popBlue();
    }
    if (blueStack.empty()) {
      return popRed();
    }
    if (redStack.peek().getValue() > blueStack.peek().getValue()) {
      return popRed();
    }
    return popBlue();
  }

  private int popRed() {
    return redStack.pop().getKey();
  }

  private int popBlue() {
    return blueStack.pop().getKey();
  }
};