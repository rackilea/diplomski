final List<Bitmap> images = ...;
final Drawable[] layers = new Drawable[images.size()];
for (int i = 0, count = images.size(); i < count; i++) {
    layers[i] = new BitmapDrawable(getResources(), images.get(i));
}
final LayerDrawable layerDrawable = new LayerDrawable(layers);