Raster raster = image.getData();
for (int j = 0; j < w; j++) {
    for (int k = 0; k < h; k++) {
        array[j][k] = raster.getSample(j, k, 0);
    }
}