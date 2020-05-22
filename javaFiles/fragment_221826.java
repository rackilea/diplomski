Bundle bundle = Platform.getBundle("your.plugin.id");

Path path = new Path("path/to/a/file.type");

URL fileURL = Platform.find(bundle, path);

InputStream in = fileURL.openStream();