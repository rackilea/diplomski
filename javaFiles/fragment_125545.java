// load
Image image = Toolkit.getDefaultToolkit().getImage(url);

// resize, internally chains as operation after loading
image = image.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);

// wait for image to be ready
MediaTracker tracker = new MediaTracker(new java.awt.Container());
tracker.addImage(image, 0);
try {
    tracker.waitForAll();
} catch (InterruptedException ex) {
    throw new RuntimeException("Image loading interrupted", ex);
}