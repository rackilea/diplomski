for (int row = 0; row < height; row++) {
    for (int col = 0; col < width; col++) {
        int mask = 0b11111111_11111111_00000000_00000000;

        int pic = image[row][col];
        int top  = (pic & mask ) >> 16;
        int bottom = (pic & ~mask) << 16;
        pic = top | bottom;
        image[row][col] = pic;
    }
}