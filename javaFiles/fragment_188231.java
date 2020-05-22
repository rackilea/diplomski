try (FileWriter writer = new FileWriter("D:/Csvfile/users.csv");) {
    writer.append(stream(keys).collect(joining(",")));
    writer.append("\r\n");
    for (int line = 0; line < maxLength; line++) {
        for (int i = 0; i < values.length; i++) {
            List<?> value = values[i];
            if (i != 0) {
                writer.append(",");
            }
            if (line < value.size()) {
                writer.append(String.valueOf(value.get(line)));
            }
        }
        writer.append("\r\n");
    }
} catch (IOException e) {
    throw new RuntimeException(e);
}