ByteArrayOutputStream baos = new ByteArrayOutputStream();
try (ZipOutputStream zipOS = new ZipOutputStream(baos)) {
    // create the Zip file content here
}
try (OutputStream out = new FileOutputStream("TEST_AS_BYTESTREAM_1.zip")) {
    baos.writeTo(out);
}