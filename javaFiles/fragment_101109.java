int position = -1;

for (int i = 0; i < bytes.length - 2; i++) {
    if (bytes[i] == (byte) 0xff && bytes[i + 1] == (byte) 0xdf) {
        position = i;
        break;
    }
}