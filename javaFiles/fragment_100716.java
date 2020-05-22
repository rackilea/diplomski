public static void copyFileUsingFileStreams(File source, File dest) throws IOException {
    String property = System.getProperty("os.name");

    if (property.equals("Linux")) {
        dest = Paths.get("/opt/myprogram/App_Data/Session.db").toFile();
    }               
    //add code to adjust dest for other os.
    Files.copy(source.toPath(), dest.toPath());
}