//This randomizes the ranks Ace through King.
        for(int i = 0; i < RANKS.length; i++)
        {
            int r = (int)(Math.random()*(i+1));
            String swap = RANKS[r];
            RANKS[r] = RANKS[i];
            RANKS[i] = swap;
        }
                                                                //the filesystem so suits will automatically
        for(String rank : RANKS) {                               //be in order when printing in groups of four
            for(File filename : files) {                         //cards.
                if(filename.getName().contains(rank)) {
                    new ImageIcon(filename.getPath()).paintIcon(this, g,
                        LEFT_PERIMETER_BEVEL + (counter/4) * (CARD_WIDTH + INTERIOR_BEVEL),
                        PERIMETER_BEVEL + (3-(counter%4)) * (CARD_HEIGHT + INTERIOR_BEVEL));
                    counter++;
                }                                                //counter/4 keeps track of the correct column
            }                                                    //3-(counter%4) keeps track of the correct row
        }                                                        //in which to print the card image