public RGBLuminanceSource(byte[] pixels, int width, int height) {
    super(width, height);

    dataWidth = width;
    dataHeight = height;
    left = 0;
    top = 0;

    // Total number of pixels suffices, can ignore shape
    int size = width * height;
    luminances = new byte[size];
    for (int offset = 0; offset < size; offset++) {
        int r  =  pixels[offset * 3    ] & 0xff; // red
        int g2 = (pixels[offset * 3 + 1] & 0xff) << 1 // 2 * green
        int b  =  pixels[offset * 3 + 2] & 0xff; // blue

        // Calculate green-favouring average cheaply
        luminances[offset] = (byte) ((r + g2 + b) / 4);
}