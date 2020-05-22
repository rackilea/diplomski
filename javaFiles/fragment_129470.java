File file = ... ;
Properties properties = new Properties();
try (FileInputStream in = new FileInputStream(file);
     Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
  properties.load(reader);
}
// use properties