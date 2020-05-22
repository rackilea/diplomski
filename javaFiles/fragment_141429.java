BufferedImage bi = javax.imageio.read("pathToGif");

     if(bi.getColorModel() instanceof IndexColorModel) {
         IndexColorModel colorModel = (IndexColorModel)bi.getColorModel();
         int colorCount = colorModel.getMapSize();
         byte[] reds = new byte[colorCount];
         byte[] greens = new byte[colorCount];
         byte[] blues = new byte[colorCount];
         colorModel.getReds(reds);
         colorModel.getGreens(greens);
         colorModel.getBlues(blues);
         Color yellow = Color.YELLOW;
         Color blue = Color.BLUE;
         for(int i = 0; i < reds.length; i++) {
            Color newColor = new Color(reds[i]&0xff, greens[i]&0xff, blues[i]&0xff);
            if(newColor.equals(yellow)) {
                reds[i] = (byte)blue.getRed();
                greens[i] = (byte)blue.getGreen();
                blues[i] = (byte)blue.getBlue();
                break;
            }
         }

     }