private class MyImageWorker extends SwingWorker<Void, Icon> {
  private static final long SLEEP_DELAY = 1000;
  private volatile boolean doneLoadingImgs = false;

  public boolean isDoneLoadingImgs() {
     return doneLoadingImgs;
  }

  public void setDoneLoadingImgs(boolean doneLoadingImgs) {
     this.doneLoadingImgs = doneLoadingImgs;
  }

  @Override
  protected Void doInBackground() throws Exception {
     while (!doneLoadingImgs) {
        BufferedImage img = captureImage();
        ImageIcon icon = new ImageIcon(img);
        publish(icon);

        Thread.sleep(SLEEP_DELAY);
     }
     return null;
  }

  @Override
  protected void process(List<Icon> iconList) {
     for (Icon icon : iconList) {
        lb.setIcon(icon);
     }
  }

  private BufferedImage captureImage() {
     FrameGrabbingControl grab = (FrameGrabbingControl) broadcast
           .getControl("javax.media.control.FrameGrabbingControl");
     Buffer buff = grab.grabFrame();
     BufferToImage image = new BufferToImage((VideoFormat) buff.getFormat());
     BufferedImage img = image.createImage(buff);
     return img;
  }
}