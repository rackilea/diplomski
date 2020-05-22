private RectF GetViewport() {
    RectF viewport = new RectF();
    Matrix viewportMatrix = new Matrix();

    translationMatrix.invert(viewportMatrix);

    viewportMatrix.mapRect(viewport, originalViewport);

    return viewport;
}