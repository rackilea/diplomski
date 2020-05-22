int[] color = new int[3];

for (int i = 0; i < pixels.length; i++) {
    // Assuming TYPE_INT_RGB, TYPE_INT_ARGB or TYPE_INT_ARGB_PRE
    // For TYPE_INT_BGR, you need to reverse the colors.

    // You seem to ignore alpha, is that correct?
    color[0] = ((pixels[i] >> 16) & 0xff); // red;
    color[1] = ((pixels[i] >>  8) & 0xff); // green;
    color[2] = ( pixels[i]        & 0xff); // blue;

    // The rest of the computations...
}