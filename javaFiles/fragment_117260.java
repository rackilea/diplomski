int[] pixels = new int[height * width];
img.getPixels(pixels, 0, width, 0, 0, width, height);

for(int pixel:pixels) {
    // check the pixel
}