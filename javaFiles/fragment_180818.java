Path file = Paths.get("tmp.properties");
Properties write = new Properties();
write.put("key", "\u00C0\u00DF\u00D6");
try (Writer writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
  write.store(writer, "demo");
}
Properties read = new Properties();
try (InputStream in = Files.newInputStream(file)) {
  read.load(in);
}
if (!write.get("key").equals(read.get("key"))) {
  throw new IOException("expected: " + write.get("key") + "; got: "
      + read.get("key"));
}