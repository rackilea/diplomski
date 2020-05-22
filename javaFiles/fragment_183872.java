// Create a Canvas Object;
Canvas c = new Canvas(bitmap);
// Value to index the byte[];
int bI = 0;
// Paint Object for drawing the pixel;
Paint p = new Paint();
// Iterate through the pixel rows;
for(int i = 0; i < height; i++) {
    // Iterate through the pixels in the row;
    for(int j = 0; j < width; j++) {
        // Pull out 4 bytes and generate colour int;
        // This entire statement depends on bytesPerPixel;
        int colorInt = Color.argb(b[bI++], b[bI++], b[bI++], b[bI++]);
        // Set the colour on the Paint;
        p.setColor(colorInt);
        // Draw the pixel;
        c.drawPoint(j, i, p);
    }
}