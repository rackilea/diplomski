String fileName = file.getAbsolutePath();
if (!fileName.endsWith(".h2.db")) {
    // not a H2 database
    return;
}
String databaseName = fileName.substring(0, fileName.length() - ".h2.db".length());
String url = "jdbc:h2:" + databaseName;