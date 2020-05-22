final float[] getPointerCoords(MotionEvent e)
{
    final int index = e.getActionIndex();
    final float[] coords = new float[] { e.getX(index), e.getY(index) };
    Matrix matrix = new Matrix();
    getImageMatrix().invert(matrix); //his drawable view extends ImageView 
                                  //so it has access to the getImageMatrix.
    matrix.postTranslate(getScrollX(), getScrollY());
    matrix.mapPoints(coords);
    return coords;
}