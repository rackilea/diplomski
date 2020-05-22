@Override
public void setImageBitmap(final Bitmap img){
    if(!changed)
        origImage = img;

    changed =true;

    super.setImageBitmap(img);
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            buildDrawingCache();
            image = getDrawingCache();
            selectedFace = null;
            faces = detector.detect(new Frame.Builder().setBitmap(image).build());

            faceRects.clear();
            for (int i = 0; i < faces.size(); i++)
                faceRects.add(getFaceRect(i));

            setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    selectedFace = null;
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_UP:
                            for (int i = 0; i < faceRects.size(); i++)
                                if (faceRects.get(i).contains((int) event.getX(), (int) event.getY())) {
                                    //Toast.makeText(context, "Touched", Toast.LENGTH_LONG).show();
                                    selectedFace = faces.valueAt(i);
                                }
                            invalidate();
                    }
                    return true;
                }
            });
        }
    });
}