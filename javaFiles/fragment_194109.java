try(
    InputStream input = new FileInputStream("in");
    OutputStream output = new FileOutputStream("out")) {
    performCopy(input, output);
} catch(IOException e) {
    // You still have to deal with it of course.
}