long[] color = new long[3];

for(int i = 0; i < pixels.length / pixel_size; i += pixel_size) {
    // Somehow assuming BGR order in input, and RGB output (color)
    // Still ignoring alpha
    color[0] = (pixels[i + pixel_offset + 2] & 0xFFFFFFFFL); // red;
    color[1] = (pixels[i + pixel_offset + 1] & 0xFFFFFFFFL); // green;
    color[2] = (pixels[i + pixel_offset    ] & 0xFFFFFFFFL); // blue;

    // The rest of the computations...
}