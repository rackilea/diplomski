StringBuilder builder = new StringBuilder();
for (int i = reader.read(); i >= 0; i = reader.read()) {
    char c = (char) i;
    if (c == '%') {
        break; // or consume the current builder, and recreate a new one
    }
    else {
        builder.append(c);
    }
}