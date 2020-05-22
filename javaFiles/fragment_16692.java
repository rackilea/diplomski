int argb =
// extract the colours. 
int red = (argb >> 16) & 0xFF;
int green = (argb >> 8) & 0xFF;
int blue = argb & 0xFF;

// reduce the number of bits.
red >>= 5;
green >>= 5;
blue >>= 6;

// build the new value
int rgb2 = (red << 5) + (green << 2) + blue;