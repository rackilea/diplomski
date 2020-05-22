Object pixel = null; // pixel initialized on first invocation of getDataElements

for (y) {
    for (x) {
       pixel = raster.getDataElements(x, y, pixel);
    }
}