for (int row = 0; row < height; row++) {
    for (int col = 0; col < width; col++) {
        int maskTop = 0b11000000_00000000_00000000_00000000;
        int maskBottom = 0b00000000_00000000_00000000_00000011;
        int pic = image[row][col];
        int top  = (pic & maskTop) >> 30;
        int bottom = (pic & maskBottom) << 30;
        pic = top | bottom | (image[row][col]&~(maskTop+maskBottom));
        image[row][col] = pic;
    }
}