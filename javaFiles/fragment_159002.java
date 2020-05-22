int argb0 = image0.getRGB(x, y);
int argb1 = image1.getRGB(x, y);

int a0 = (argb0 >> 24) & 0xFF;
int r0 = (argb0 >> 16) & 0xFF;
int g0 = (argb0 >>  8) & 0xFF;
int b0 = (argb0      ) & 0xFF;

int a1 = (argb1 >> 24) & 0xFF;
int r1 = (argb1 >> 16) & 0xFF;
int g1 = (argb1 >>  8) & 0xFF;
int b1 = (argb1      ) & 0xFF;

int aDiff = Math.abs(a1 - a0);
int rDiff = Math.abs(r1 - r0);
int gDiff = Math.abs(g1 - g0);
int bDiff = Math.abs(b1 - b0);

int diff = 
    (aDiff << 24) | (rDiff << 16) | (gDiff << 8) | bDiff;
result.setRGB(x, y, diff);