@Override String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("[");
  for (int i = 0; i < a.length - 1; ++i) {
    sb.append(a[i]);
    sb.append(", ");
  }
  if (a.length > 0) {
    sb.append(a[a.length - 1]);
  }
  sb.append("]");
  return sb.toString();
}