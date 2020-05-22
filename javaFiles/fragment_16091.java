compressedImage = new Compressor(this)
            .setMaxWidth(640)
            .setMaxHeight(480)
            .setQuality(75)
            .setCompressFormat(Bitmap.CompressFormat.WEBP)
            .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
              Environment.DIRECTORY_PICTURES).getAbsolutePath())
            .compressToFile(actualImage);