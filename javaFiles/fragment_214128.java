try (FileOutputStream file = new FileOutputStream(out),
    DeflaterOutputStream deflater = new DeflaterOutputStream(file),
    OutputStreamWriter writer = new OutputStreamWriter(deflater, StandardCharsets.UTF_8),
    BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
  // Write to bufferedWriter here
}