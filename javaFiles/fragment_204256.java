JFileChooser fc = new JFileChooser();
    if(fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION){
        BufferedImage img = ImageIO.read(fc.getSelectedFile());
        ImageIcon imageIcon = new ImageIcon(new 
        ImageIcon(img).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        yourLabel.setIcon(imageIcon);
      }