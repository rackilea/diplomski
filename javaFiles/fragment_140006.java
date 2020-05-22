destination.copy(source, 0, 0, source.width, source.height, 0, 0, source.width, source.height);
for (int x = 0; x < source.width; x++) {
    for (int y = 0; y < source.height; y++) {
        int loc = x + y * source.width;

        if (x > xStart && x < xEnd && y > yStart && y < yEnd) {
            if ( average )
                destination.pixels[loc] = convolution(x, y, matrix_3_3_average, 3, source);
            else
                destination.pixels[loc] = convolution(x, y, matrix_3_3_sharpen, 3, source);
        }
    }
}

source.copy(destination, 0, 0, source.width, source.height, 0, 0, source.width, source.height);