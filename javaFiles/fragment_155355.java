private void centerViewOn(double x, double y){
    double viewportWidth    = scrollPane.getViewportBounds().getWidth();
    double maxHscrollPixels = gridPane.getWidth() - viewportWidth;
    double hscrollPixels    =  (x + 0.5) * gridPane.getWidth() / dimensionX - viewportWidth / 2;
    scrollPane.setHvalue(hscrollPixels / maxHscrollPixels);

    double viewportHeight   = scrollPane.getViewportBounds().getHeight();
    double maxVscrollPixels = gridPane.getHeight() - viewportHeight;
    double vscrollPixels    =  (y + 0.5) * gridPane.getHeight() / dimensionY - viewportHeight / 2;
    scrollPane.setVvalue(vscrollPixels / maxVscrollPixels);
}