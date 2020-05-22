hueBarColors = new int[hueBarWidth];

     /*
     * We have 7 main colors, 6 intervals are then needed.
     */
    int nbPix = hueBarWidth / 6;

     /*
     * for each FF we define the Step needed to accomplish a shading effect.
     */
    float step = 255 / nbPix;

    int red = 0;
    int green = 0;
    int blue = 0;
    int index = 0;

    /*
     * Defines the color values going from Red FF 00 00 to Yellow FF FF 00
     */
    for (int i = 0; i < nbPix; i++){

        hueBarColors[index] = Color.rgb(255, green, 0);  
        index++;
        green += step;

    }

    /*
     * From Yelow FF FF 00 to Green 00 FF 00
     */     
    for (int i = 0; i < nbPix; i++){

        hueBarColors[index] = Color.rgb(255 - red, 255, 0);  
        index++;
        red += step;

    }

    /*
     *  From Green 00 FF 00 to  Cyan 00 FF FF       
     */
    for (int i = 0; i < nbPix; i++){

        hueBarColors[index] = Color.rgb(0, 255, blue);  
        index++;
        blue += step;

    }       

    /*
     * From Cyan 00 FF FF to Blue 00 00 FF      
     */
    green = 0;
    for (int i = 0; i < nbPix; i++){

        hueBarColors[index] = Color.rgb(0, 255 - green, 255);  
        index++;
        green += step;

    }

    /*
     * From Blue 00 00 FF to Magenta FF 00 FF       
     */
    red = 0;
    for (int i = 0; i < nbPix; i++){

        hueBarColors[index] = Color.rgb(red, 0, 255);  
        index++;
        red += step;

    }   

    /*
     * From Magenta FF 00 FF to Red FF 00 00        
     */
    blue = 0;
    for (int i = 0; i < nbPix; i++){

        hueBarColors[index] = Color.rgb(255, 0, 255 - blue);  
        index++;
        blue += step;

    }