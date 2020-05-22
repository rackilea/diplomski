int n = 0;
for (byte b : data) {
    if (32 <= b && b < 127) { // Within ASCII
        data[n++] = b;
    }
}
String datastr = new String(data, 0, n, StandardCharsets.US_ASCII);