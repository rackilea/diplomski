_imageToErase = (WScratchView) findViewById(R.id.image_to_erase);
Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_erase);

_imageToErase.setScratchBitmap(bitmap);


_imageToErase.setOnScratchCallback(new WScratchView.OnScratchCallback() {
        @Override
        public void onScratch(float percentage) {
            updatePercentage(percentage);
        }

        @Override
        public void onDetach(boolean fingerDetach) {
            if (mPercentage > 40) {
                _imageToErase.setScratchAll(true);
                updatePercentage(100);
            }
        }
    });