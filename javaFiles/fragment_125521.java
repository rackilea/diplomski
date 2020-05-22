@Override public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < size; i++) {
        if (i > 0) {
            builder.append(" ");
        }
        builder.append(InitialArray[i]);
    }
    return builder.toString();
}