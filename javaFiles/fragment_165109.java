@Test
public void testXPackage() throws IOException {
    for (int packageByte : X_PACKAGE) {
        pw.write(packageByte);
    }
    pm.flush(); // <<--- added this line.

    while (is.available() > 0) {
        System.out.println(is.read());
    }
}