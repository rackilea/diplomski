Bundle bundle = Platform.getBundle("your plugin id");

URL url = FileLocator.find(bundle, new Path("path relative to the plugin"), null);

URL fileUrl = FileLocator.toFileURL(url);

File file = new File(fileUrl.getFile());

... read file using normal Java file APIs