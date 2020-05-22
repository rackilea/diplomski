FastBitmap fb = new FastBitmap(bufferedImage);
fb.toGrayscale();

BradleyLocalThreshold b = new BradleyLocalThreshold();
b.applyInPlace(fb);

bufferedImage = fb.toBufferedImage();