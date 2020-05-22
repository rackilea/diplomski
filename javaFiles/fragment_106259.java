byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
data = new String(bytes, StandardCharsets.UTF_8); // Inverse.

int crc = 0;
for (byte b : bytes) {
    int n = b & 0xFF; // An int 0 .. 255 without sign extension
    crc ^= n;
}