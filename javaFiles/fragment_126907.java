FileInputStream inputStream = new FileInputStream("FILEPATH/FILENAME");
try {
    String everything = IOUtils.toString(inputStream);
} finally {
    inputStream.close();
}