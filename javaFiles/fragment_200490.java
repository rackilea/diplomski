@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append(getClass().getName());
  sb.append(": ");
  for (Field f : getClass().getDeclaredFields()) {
    sb.append(f.getName());
    sb.append("=");
    sb.append(f.get(this));
    sb.append(", ");
  }
  return sb.toString();
}