@Override
public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(name);
    builder.append(";");
    builder.append(number);
    builder.append("\n");
    return builder.toString();
}