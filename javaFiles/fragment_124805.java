Path path = Paths.get("test.txt");
Charset charset = StandardCharsets.UTF_8;

String content = new String(Files.readAllBytes(path), charset);
content = content.replaceAll("foo", "bar");
Files.write(path, content.getBytes(charset));