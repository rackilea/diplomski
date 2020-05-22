byte[] data = ((DataBufferByte) bgr.getRaster().getDataBuffer()).getData();
for (int i = 0; i < data.length; i += 3) {
    // Swap 1st and 3rd component
    byte b = data[i];
    data[i] = data[i + 2];
    data[i + 2] = b;
 }