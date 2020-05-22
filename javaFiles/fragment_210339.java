private static int convertYUVtoRGB(int y, int u, int v) {
    int r,g,b;

    r = y + (int)1.402f*v;
    g = y - (int)(0.344f*u +0.714f*v);
    b = y + (int)1.772f*u;
    r = r>255? 255 : r<0 ? 0 : r;
    g = g>255? 255 : g<0 ? 0 : g;
    b = b>255? 255 : b<0 ? 0 : b;
    return 0xff000000 | (b<<16) | (g<<8) | r;
}