for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
           if (((i + j) % 2) == 0) {
              boardFrame[i][j].setBackground(new Color(15, 81, 162));

           } else {
              boardFrame[i][j].setBackground(new Color(77, 77, 77));
           }
           boardFrame[i][j].addMouseListener(this); // !! here !!
        }

     }