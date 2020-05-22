final Matrix transformationMatrix = new Matrix();
imagen.getImageMatrix().invert(transformationMatrix);
transformationMatrix.postTranslate(imagen.getScrollX(), imagen.getScrollY());
imagen.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float[] transformedCoords = getPointerCoords(event);
        int x = (int)transformedCoords[0];
        int y = (int)transformedCoords[1];
        filler.prepare();
        filler.floodFill(x, y);
        imagen.setImageBitmap(filler.getImage());
        return false;
    }

    final float[] getPointerCoords(MotionEvent e) {
        final int index = e.getActionIndex();
        final float[] coords = new float[] { e.getX(index), e.getY(index) };
        transformationMatrix.mapPoints(coords);
        return coords;
    }
});