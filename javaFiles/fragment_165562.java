public String filteredrgbValue(){ 
        BufferedImage filtered = filteredImage;

        Color filteredRGBValue = new Color(filtered.getRGB(125, 125));

        // you are declaring new variables here, hiding your member variables...
        //int filteredred = filteredRGBValue.getRed();
        //int filteredgreen = filteredRGBValue.getGreen();
        //int filteredblue = filteredRGBValue.getBlue();

        filteredred = filteredRGBValue.getRed();
        filteredgreen = filteredRGBValue.getGreen();
        filteredblue = filteredRGBValue.getBlue();

        return fRGBValue = "(" + filteredred + "," + filteredgreen + "," + filteredblue + ")";        
    }