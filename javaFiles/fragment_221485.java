public BufferedImage toBufferedImage(final Image image, final int type) {
    //Test if image does not need conversion
    if (image instanceof BufferedImage)
        return (BufferedImage) image;
    //Check if image can be converted easily
    if (image instanceof VolatileImage)
        return ((VolatileImage) image).getSnapshot();
    //loadImage method ensures that the image has loaded fully (it could be from the web or something). If you are sure that when this method is called - the image is loaded, you can remove this line and whole method.
    loadImage(image);
    //Create new BufferedImage with the same width and height and given data type (see constants in BufferedImage API)
    final BufferedImage buffImg = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
    //Get graphics out of our new BufferedImage. Graphics2D is used to draw something on the image
    final Graphics2D g2 = buffImg.createGraphics();
    //Use Graphics2D to draw our Image contents on top of BufferedImage
    g2.drawImage(image, null, null);
    //We no longer need our graphics object as we drawn everything we wanted
    g2.dispose();
    //Return BufferedImage
    return buffImg;
}

//Method that ensures that the image was loaded succesfully
private void loadImage(final Image image) {
    //Inner class implementing the ImageObserver interface. It will be used to track the image loading progress
    class StatusObserver implements ImageObserver {
        boolean imageLoaded = false;
            //Each time an image updates - it will call this method
        public boolean imageUpdate(final Image img, final int infoflags, 
              final int x, final int y, final int width, final int height) {
                    //When flags contains ALLBITS flag - that means that the image was fully loaded.
            if (infoflags == ALLBITS) {
                synchronized (this) {
                                    //Therefore we set status to true
                    imageLoaded = true;
                                    //And notify anyone who was waiting for our job to be done
                    notify();
                }
                return true;
            }
            return false;
        }
    }
    //Then we create the observer itself
    final StatusObserver imageStatus = new StatusObserver();
    //We aquire it's monitor with this synchronized block. This will allow us to "wait" for it to complete loading (see notify() in StatusObserver)
    synchronized (imageStatus) {
            //Basically if image is loaded - it will have it's width and height set
        if (image.getWidth(imageStatus) == -1 || image.getHeight(imageStatus) == -1) {
                    //While status observer is not loaded
            while (!imageStatus.imageLoaded) {
                try {
                                    //We wait for status observer to notify us
                    imageStatus.wait();
                } catch (InterruptedException ex) {}
            }
        }
    }
}