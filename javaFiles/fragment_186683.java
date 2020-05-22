@Override
  protected void process(List<BufferedImage> mystuff) {
     for (BufferedImage bImage : mystuff) {
        img_field.setIcon(new ImageIcon(bImage));
     }
  }