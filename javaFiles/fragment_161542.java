InputStream input = new BufferedInputStream(new FileInputStream("C:/logs.txt"));
byte[] buffer = new byte[8192];

try {
    for (int length = 0; (length = input.read(buffer)) != -1;) {
        System.out.write(buffer, 0, length);
    }
} finally {
    input.close();
}