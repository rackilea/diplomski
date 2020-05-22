FileInputStream inputStream = new FileInputStream("foo.java");
try {
    String everything = IOUtils.toString(inputStream);
} finally {
    inputStream.close();
}