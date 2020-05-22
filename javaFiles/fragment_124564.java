String rgbSource = getRGBSource(); //your function to get a string version of it
int in = Integer.decode(rgbSource);
int red = (in >> 16) & 0xFF;
int green = (in >> 8) & 0xFF;
int blue = (in >> 0) & 0xFF;
int out = (blue << 16) | (green << 8) | (red << 0);