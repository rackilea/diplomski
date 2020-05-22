byte[] bytearray = encryptedImag.getBytes();
InputStream input = new ByteArrayInputStream(bytearray));
String outputRecoverdFileName = Integer.toString(i) + "_recoverd.jpg";
OutputStream output = new FileOutputStream(new File(encryptedFileDir, outputRecoverdFileName)));
try {
    copy(input, output);
}
finally {
    output.close();
}