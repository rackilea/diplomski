int argb0 = image0.getRGB(x, y);
int argb1 = image1.getRGB(x, y);

// Here the 'b' stands for 'blue' as well
// as for 'brightness' :-)
int b0 = argb0 & 0xFF;
int b1 = argb1 & 0xFF;
int bDiff = Math.abs(b1 - b0);

int diff = 
    (255 << 24) | (bDiff << 16) | (bDiff << 8) | bDiff;
result.setRGB(x, y, diff);