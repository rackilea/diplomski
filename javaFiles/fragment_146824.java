static {
    Image currentImage = null;
    try {
      currentImage = new Image("res/images/asteroid_blue.png");
    } catch (Exception e) {
      // catch exception - do other stuff
    } finally {
      if (currentImage != null) {
        WIDTH = currentImage.getWidth();
        HEIGHT = currentImage.getHeight();
      } else {
        // initialise default values
        WIDTH = 0;
        HEIGHT = 0;
      }
    }
  }