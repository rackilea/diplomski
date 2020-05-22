@Override
public void onViewTap(View view, float x, float y) {
    photoView.invalidate()
    bitmap = photoView.getDrawingCache();
    // ...
}