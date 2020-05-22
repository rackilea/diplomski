// JAR File Reading
String filePath = DirectoryReader.class.getClassLoader().getResource(directoryPath).getPath();

filePath = filePath.substring(0, filePath.indexOf("!"));

URL url = new URL(filePath);

Path configJARLocation = Paths.get(url.toURI());

InputStream inputStream = Files.newInputStream(configJARLocation);
ZipInputStream zipInputStream = new ZipInputStream(inputStream);
InputStreamReader inputStreamReader = null;