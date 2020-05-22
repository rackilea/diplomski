try {
    String line;
    while ((line = reader.readLine()) != null) {
        read += line; // Or builder.append(line);
    }
} catch (IOException e) {
    // Whatever you want to do
}