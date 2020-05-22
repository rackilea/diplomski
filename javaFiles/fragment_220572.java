Writer writer = new FileWriter("/foo.txt");

try {
    writer.write(text);
} finally {
    writer.close();
}