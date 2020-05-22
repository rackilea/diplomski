int uvp = frameSize + (row >> 1) * width, u = 0, v = 0;
    int yp = row*width + column;
    int y = (0xff & ((int) yuv420sp[yp])) - 16;
    if (y < 0) y = 0;
    if ((column & 1) == 0) {
        v = (0xff & yuv420sp[uvp++]) - 128;
        u = (0xff & yuv420sp[uvp++]) - 128;
    }

    int y1192 = 1192 * y;
    int r = (y1192 + 1634 * v);
    int g = (y1192 - 833 * v - 400 * u);
    int b = (y1192 + 2066 * u);

    if (r < 0) r = 0; else if (r > 262143) r = 262143;
    if (g < 0) g = 0; else if (g > 262143) g = 262143;
    if (b < 0) b = 0; else if (b > 262143) b = 262143;

    result = 0xff000000 | ((r << 6) & 0xff0000) | ((g >> 2) & 0xff00) | ((b >> 10) & 0xff);