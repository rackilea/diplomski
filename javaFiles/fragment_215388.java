final ImageView iv = (ImageView) findViewById(R.id.imageView);
    ViewTreeObserver vto = iv.getViewTreeObserver();
    vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            // Start at 60
            Log.d("test", "Before"+String.valueOf(iv.getWidth()* iv.getScaleX()));
            iv.setScaleX((float) .5);
            // Still at 60 after scale
            Log.d("test", "After"+String.valueOf(iv.getWidth()* iv.getScaleX()));
        }

    });