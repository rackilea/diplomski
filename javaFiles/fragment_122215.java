preview = new Preview(this);
    ((FrameLayout) findViewById(R.id.preview)).addView(preview);

    buttonClick = (Button) findViewById(R.id.buttonClick);
    buttonClick.setOnClickListener( new OnClickListener() {
        public void onClick(View v) {
            preview.camera.takePicture(shutterCallback, rawCallback, jpegCallback);
        }
    });