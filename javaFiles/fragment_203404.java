alpha = (argb >> 24) & 0xfc;
red = (argb >> 16) & 0xfc;
green = (argb >> 8) & 0xfc;
blue = argb & 0xfc;
bytes[0] = alpha | (red >> 6);
bytes[1] = (red << 2) | (green >> 4);
bytes[2] = (green << 4) | (blue >> 2);