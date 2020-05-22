for (int row = 0; row < 4; row++)
 {
     Collections.shuffle(RANKS);
     for(String rank : RANKS) {                             
            for(File filename : files) {                         
                if(filename.getName().contains(rank)) {
                    new ImageIcon(filename.getPath()).paintIcon(this, g,
                        LEFT_PERIMETER_BEVEL + (counter/4) * (CARD_WIDTH + INTERIOR_BEVEL),
                        PERIMETER_BEVEL + (row) * (CARD_HEIGHT + INTERIOR_BEVEL));
                    counter++;
                }                                               
            }                                                    
        }       
  }