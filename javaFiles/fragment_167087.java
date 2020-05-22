private Bitmap getBitmap(View v) {
v.clearFocus();
v.setPressed(false);

boolean willNotCache = v.willNotCacheDrawing();
v.setWillNotCacheDrawing(false);

// Reset the drawing cache background color to fully transparent
// for the duration of this operation
int color = v.getDrawingCacheBackgroundColor();
v.setDrawingCacheBackgroundColor(0);

if (color != 0) {
    v.destroyDrawingCache();
}
v.buildDrawingCache();
Bitmap cacheBitmap = v.getDrawingCache();
if (cacheBitmap == null) {
    Toast.makeText(StopWarApp.getContext(), "Something went wrong",
            Toast.LENGTH_SHORT).show();
    return null;
}

Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);

// Restore the view
v.destroyDrawingCache();
v.setWillNotCacheDrawing(willNotCache);
v.setDrawingCacheBackgroundColor(color);

return bitmap;