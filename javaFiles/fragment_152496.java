String homeDir = System.getProperty("user.home");
String myAppFolderName = ".MyApp";
Path installDir = Paths.get(homeDir, "AppData");
if (!Files.isDirectory(installDir) { // Maybe not Windows
    installDir = Paths.get(homeDir);
}
Path myAppFolder = Paths.get(installDir.toString(), myAppFolderName);
Files.createDirectory(myAppFolder);

Path sources = Paths.get(new URI("jar:file://... .jar!/install_image"));
Files.copy(sources, myAppFolder);