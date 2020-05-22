Path sourcePath = Paths.get("C:/data/arab.txt");
byte[] sourceData = Files.readAllBytes(sourcePath);

String s = new String(sourceData, "ISO-8859-6");

byte[] targetData = s.getBytes(StandardCharsets.UTF_8);
Files.write(targetData, targetPath, StandardOpenOption.REPLACE_EXISTING);