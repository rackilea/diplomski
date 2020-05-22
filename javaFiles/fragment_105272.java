int alpha = 255; 
int red   = 0;
int green = 255;
int blue  = 0;

int argb = alpha << 24 + red << 16 + green << 8 + blue

image.setRGB(i, j, argb);