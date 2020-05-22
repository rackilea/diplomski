private Widget lastImage = null;

private OnLoadPreloadedImageHandler showImage = new OnLoadPreloadedImageHandler() {
  public void onLoad(PreloadedImage image) {
    if (lastImage != null) {
      lastImage.removeFromParent()
    }
    lastImage = image;
    image.setWidth("75px");
    panelImages.add(image);
  }
};