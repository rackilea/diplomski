double xw = x / width;
double yw = y / width;

if (xw > yw) {
    return xw;
} else {
    return yw;
}