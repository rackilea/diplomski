class Value implements Comparable<Value> {

  int index;
  dobule value;

  public int compareTo(Value val) {
    return Double.compare(this.value, val.value);
  }
}