public class BackgroundPane extends JPanel {

  private Image image;

  public BackgroundPane(Image image) {
    super();
    this.setOpaque(false);
    this.image = image;
  }

  @Override
  protected void paintComponent(Graphics grphcs) {
    super.paintComponent(grphcs);
    // Draw image in center of component
    grphcs.drawImage(image, getWidth() / 2 - image.getWidth(this) / 2,
                            getHeight() / 2 - image.getHeight(this) / 2, 
                            this);
  }

}