// Convert data to jpeg first then to bitmap (cant convert byte array directly to bitmap)
              YuvImage yuvimage=new YuvImage(data, ImageFormat.NV21, 100, 100, null);
              ByteArrayOutputStream baos = new ByteArrayOutputStream();
              yuvimage.compressToJpeg(new Rect(0, 0, 100, 100), 80, baos);
              byte[] jdata = baos.toByteArray();

              // Convert to Bitmap
              Bitmap bmp = BitmapFactory.decodeByteArray(jdata, 0, jdata.length);
              System.out.println("Bitmap Name 3" + bmp);