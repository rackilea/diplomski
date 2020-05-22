public int compareTo(Pair<K, V> o) {
  V val1 = o.getValue();
  V val2 = this.getValue();

  return val1.compareTo(val2);
}