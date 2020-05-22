public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Description: ");
    builder.append(description);
    builder.append(";");
    builder.append("Price");
    builder.append(price);
    return builder.toString();
}