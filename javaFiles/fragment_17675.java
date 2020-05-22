// !!! CAVEAT: code not compiled nor tested !!!

// TOTAL_IMAGE_COUNT is a constant that defines the array size
// an ArrayList might be better though
BufferedImage[] myImages = new BufferedImage[TOTAL_IMAGE_COUNT];
int i = 0;
while (rs.next()) {
    String imagePath = rs.getString("path");
    System.out.println(imagePath + "\n");
    System.out.println("TESTING - READING IMAGE");

    myImages[i] = ImageIO.read(new File(imagePath));
    imglab[i] = new JLabel(new ImageIcon(myImages[i]));
    imgPanel[i]= new JPanel();
    imgPanel[i].add(imglab[i]);
    loadcard.add(imgPanel[i], i);     
    i++;                 
}//EndWhile