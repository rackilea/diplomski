String filename = new String(APDirectory.META_DATA.getPath() + getDefaultFileName() + ".ini");
System.out.println(APDirectory.META_DATA.getPath() + getDefaultFileName() + ".ini");
File iniFile = new File(filename);

Wini ini;

try {
    iniFile.createNewFile();
    ini = new Wini(iniFile);
    ini.put(title, "Comment:", comment);
    ini.put(title, "Position:", rectangle.x + "," + rectangle.y + "," + rectangle.width + "," + rectangle.height);
    ini.store();
} catch (InvalidFileFormatException e) {
// TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}