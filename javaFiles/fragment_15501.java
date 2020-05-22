public int getFontSize(JTextField text, int columnsToHold){
            //Create a sample test String (we will it later in our calculations)
            String testString = "";
            for(int i = 0; i<columnsToHold; i++){
                  testString = testString + "5";
            }


             //size will hold the optimal Vertical point size for the font
      Boolean up = null;
      int size = text.getHeight();  
      Font font;
     while (true) {
        font = new Font("Default", 0, size);
        int testHeight = getFontMetrics(font).getHeight();
        if (testHeight < height && up != Boolean.FALSE) {
            size++;
            up = Boolean.TRUE;
        } else if (testHeight > height && up != Boolean.TRUE) {
            size--;
            up = Boolean.FALSE;
        } else {
           break;
        }
    }
        //At this point, size holds the optimal Vertical font size

        //Now we will calculate the width of the sample string
    BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    FontMetrics fm = img.getGraphics().getFontMetrics(font);
    int width = fm.stringWidth(testString);

        //Using Martijn's answer, we calculate the optimal Horizontal font size
    int newFontSize = size * textos[0].getWidth()/width;

        //The perfect font size will be the minimum between both optimal font sizes.
        //I have subtracted 2 from each font so that it is not too tight to the edges
    return Math.min(newFontSize-2, size-2);
}