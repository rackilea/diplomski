class ImageEvent {
  private boolean imageLoaded; //plus getter/setter and maybe initialized in constructor
}    

interface ImageListener {
  void imageChanged(ImageEvent e);
}

...

List<ImageListener> listeners;

...

try
{
    imagePath = DialogIO.displayOpenDialog();
    effects = ImageInOut.loadImage(imagePath);                
    imageHolder.setIcon(new ImageIcon(effects));
    bmpFound = true;

    ImageEvent imgageEvent = new ImageEvent();
    imageEvent.setImageLoaded(true);

    for( ImageListener l : listeners ) {
      l.imageChanged(imageEvent);
    }
}

...