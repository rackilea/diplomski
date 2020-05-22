public byte[] hexStrToByteArray(String hex) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(hex.length() / 2);

    for (int i = 0; i < hex.length(); i += 2) {
        String output = hex.substring(i, i + 2);
        int decimal = Integer.parseInt(output, 16);
        baos.write(decimal);
    }
    return baos.toByteArray();
}