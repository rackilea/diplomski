public final ImageReader.OnImageAvailableListener mOnImageAvailableListener
            = new ImageReader.OnImageAvailableListener() {
    @Override
    public void onImageAvailable(final ImageReader reader) {
            Image image = null;
            try {
                image = reader.acquireLatestImage();
                ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                byte[] imageBytes = new byte[buffer.remaining()];
                buffer.get(imageBytes);
                final Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

                YourClassNameHere.this.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                       textView.append("a"); // crashes here
                });

            } finally {
                if (image != null) {
                    image.close();
                }
            }
            }

    }
    };