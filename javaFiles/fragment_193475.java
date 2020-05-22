final int w = bitmap.getWidth();
final int h = bitmap.getHeight();

final WritableRaster wr = bitmap.getData();
bitfloat = wr.getPixels(0, 0, w, h, bitfloat);

// do processing here

wr.setPixels(0, 0, w, h, bitfloat);