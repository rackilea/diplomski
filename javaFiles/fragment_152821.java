try (OutputStreamWriter ows = new OutputStreamWriter(new FileOutputStream("a.txt"))) {
    ows.write('a');
}
try (FileOutputStream fos = new FileOutputStream("b.txt")) {
    fos.write('b');
}