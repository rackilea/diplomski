List<ImageIcon> images = new ArrayList<ImageIcon>();// Array list

for (int fileInList = 0; fileInList < files.length; fileInList++) {
 if (files[fileInList].isFile()) {
   Image baseImage = ImageIO.read(files[fileInList]);
   Image scaledImage = baseImage.getScaledInstance(85, 100,  java.awt.Image.SCALE_SMOOTH);   
   images.add(0, new ImageIcon(scaledImage));
 }
}