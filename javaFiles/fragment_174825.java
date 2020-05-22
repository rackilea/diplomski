int w = img.getWidth();
int h = img.getHeight();

DataBufferUShort buffer = (DataBufferUShort) img.getRaster().getDataBuffer(); // Safe cast as img is of type TYPE_USHORT_GRAY 

// Conveniently, the buffer already contains the data array
short[] arrayUShort = buffer.getData();

// Access it like:
int grayPixel = arrayUShort[x + y * w] & 0xffff;

// ...or alternatively, if you like to re-arrange the data to a 2-dimensional array:
int[][] array = new int[w][h];

// Note: I switched the loop order to access pixels in more natural order
for (int y = 0; y < h; y++) {
    for (int x = 0; x < w; x++) {
        array[x][y] = buffer.getElem(x + y * w);
        System.out.print(array[x][y]);
    }
}

// Access it like:
grayPixel = array[x][y];