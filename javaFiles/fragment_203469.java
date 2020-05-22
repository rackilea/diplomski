for(int i=0; i<rows; i++) {
        for(int j=0; i<cols; j++) {.
            block[i][j] = new JButton();
            block[i][j].setIcon(randomizer());
            block[i][j].addActionListener(this);
            boardBg.add(block[i][j]);
        }
    }