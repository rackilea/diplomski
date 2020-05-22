OutputStream output = new FileOutputStream("/foo.txt");

try {
    output.write(text.getBytes());
} finally {
    output.close();
}