width = ImageLibrary.getImageWidth();
height = ImageLibrary.getImageHeight();

// Loop from the top of the image to the bottom
for (y = 0; y < height ; y++) {

    // Loop halfway across each row because going all the way will result
    // in all the numbers being put back where they were to start with
    for (x = 0; x < width / 2 ; x++) {

        // Here, `y * width` gets the row, and `+ x` gets position in that row
        double temp = img[y * width + x];

        // Here, `width - x - 1` gets x positions in from the end of the row
        // Subtracting 1 because of 0-based index
        img[y * width + x] = img[y * width + (width - x - 1)];
        img[y * width + (width - x - 1)] = temp;
    }
}