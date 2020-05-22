public static void main(String[] args) throws Exception {
    Path path = Paths.get("path/to/file");
    byte[] data = Files.readAllBytes(path);

    char[] hexArray = "0123456789ABCDEF".toCharArray();
    char[] hexChars = new char[data.length * 2];
    for ( int j = 0; j < data.length; j++ ) {
        int v = data[j] & 0xFF;
        hexChars[j * 2] = hexArray[v >>> 4];
        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    System.out.println(new String(hexChars));
}