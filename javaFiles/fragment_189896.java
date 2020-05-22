int w = p.getWidth();
  int h = p.getHeight();

  int[] pixels = new int[w * h];      
  for (int y=0; y<h; y++) {
     for (int x=0; x<w; x++) {
        //convert RGBA to RGB
        int value = p.getPixel(x, y);
        int R = ((value & 0xff000000) >>> 24);
        int G = ((value & 0x00ff0000) >>> 16);
        int B = ((value & 0x0000ff00) >>> 8);
        int A = ((value & 0x000000ff));

        int i = x + (y * w);
        pixels[ i ] = (A << 24) | (R << 16) | (G << 8) | B;
     }
  }

  Bitmap b = Bitmap.createBitmap(pixels, w, h, Config.ARGB_8888);
  b.compress(CompressFormat.JPEG, quality, handle.write(false));