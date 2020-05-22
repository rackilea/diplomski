int pixel = image.getRGB(1, 1);

// extract your gray value from blue, assume red and green are same
int gray = pixel & 0xFF; 

// this method does your manipulation on the gray value, 0 to 255
gray = manipulate(gray);

// recombine back into int, preserving the original alpha
int newPixel = (pixel & 0xFF000000) | (gray << 16) | (gray << 8) | gray;

// now you can set your new pixel
image.setRGB(1, 1, nexPixel);