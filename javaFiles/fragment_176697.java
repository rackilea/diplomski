FileInputStream inputStream = new FileInputStream(inputFile);
FileOutputStream fileout = new FileOutputStream(outputFile);
CipherOutputStream out = new CipherOutputStream(fileout , cipher);

try {
    byte[] buffer = new byte[8192];
    int count;

    while ((count = inputStream.read(buffer)) > 0) {
        out.write(buffer, 0, count);
    }
} finally {
    out.close();
    inputStream.close();
}