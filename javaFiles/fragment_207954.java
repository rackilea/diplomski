// Example code
RenderScript mRS;
Allocation inputAllocation;
Allocation outputAllocation;
ScriptC_magnifier magnifier;

ImageView originalImageView;
ImageView zoomedImageView;

Bitmap inputImage, outputImage;

private void example() {
    // ImageViews that will handle input and output
    originalImageView = (ImageView) findViewById(R.id.imageView);
    zoomedImageView = (ImageView) findViewById(R.id.imageView2);

    // Initialize RenderScript context
    initRS();

    // Perform first magnification
    magnify();

    // Set up a click listener on the magnified image.
    // When touched, the magnifier will be moved to the touch position.
    zoomedImageView.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int touchX = (int) event.getX();
            int touchY = (int) event.getY();

            Log.d("Touch", String.format("Touch: %d, %d", touchX, touchY));

            magnifier.set_atX(touchX);
            magnifier.set_atY(touchY);

            magnify();

            return false;
        }
    });
}

private void initRS() {
    mRS = RenderScript.create(this);

    // Our magnifier script
    magnifier = new ScriptC_magnifier(mRS);

    // Input image
    inputImage = BitmapFactory.decodeResource(getResources(), R.drawable.houseimage);
    originalImageView.setImageBitmap(inputImage);
    inputAllocation = Allocation.createFromBitmap(mRS, inputImage);
    outputAllocation = Allocation.createTyped(mRS, inputAllocation.getType());

    // Initializes magnifier
    magnifier.set_inputAllocation(inputAllocation);
    magnifier.set_atX(300);
    magnifier.set_atY(230);
    magnifier.set_radius(100);
    magnifier.set_scale(3);
}

private void magnify() {
    // Run the kernel
    magnifier.forEach_magnify(inputAllocation, outputAllocation);

    // Displays the magnification output
    outputImage = Bitmap.createBitmap(inputImage.getWidth(), inputImage.getHeight(), Bitmap.Config.ARGB_8888);
    outputAllocation.copyTo(outputImage);

    zoomedImageView.setImageBitmap(outputImage);
}