String imageLocation = "lmkpackage/images/";
  String[] imageNames = {"one", "two", "three", "four", "five"};
  String imgExt = ".jpg";

  int count = 1;

  for (String imageName : imageNames) {
     String imagePath = imageLocation + imageName + imgExt;
     BufferedImage img = ImageIO.read(new File(imagePath));
     ImageIcon icon = new ImageIcon(img);
     JLabel label = new JLabel(icon);
     loadcard.add(label, String.valueOf(count));
     count++;
  }