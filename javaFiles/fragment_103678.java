public static int stripesColor(int column, int row, int imWidth, int imHeight) {
    // Just worry about the square in the center for now.

    // If pixel is not in left/bottom or top/right quarters:
    if (imWidth / 4 < column < (imWidth * 3)/4) && 
    (imHeight / 4 < row < (imHeight * 3)/4) {

        return Color.hotpink.getRGB();

    } else if {
        // We know that any pixel in the center square is already taken care of, 
        // so the logic for the rest can completely ignore that.
        // It can be written as though the square isn't in the image at all.
    } else {
        // Last remaining color
    }
}