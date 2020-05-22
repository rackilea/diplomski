FileOutputStream out = null;
        String path = setOutputFilePath();
        try {
            out = new FileOutputStream(path);
            croppedBitmap2.compress(Bitmap.CompressFormat.JPEG, 100, out); // bmp is your Bitmap instance
            // PNG is a lossless format, the compression factor (100) is ignored

            LOGGER.debug("Saving image on the absolute path folder!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }