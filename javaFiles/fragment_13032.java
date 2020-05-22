Path oldPath = Paths.get("C:/Temp/old.txt");
Path newPath = Paths.get("C:/Temp/new.txt");
byte[] bytes = Files.readAllBytes(oldPath);
String content = "\uFEFF" + new String(bytes, "Windows-1252");
bytes = content.getBytes("UTF-8");
Files.write(newPath, bytes, StandardOption.WRITE);