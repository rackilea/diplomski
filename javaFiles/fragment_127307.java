public void mouseClicked(MouseEvent arg0) {
        if(playerOne) {
            playerOne = false;
            playerTwo = true;
            boxOne.setIcon(xIcon);                  
        } else if(playerTwo) {
            playerOne = true;
            playerTwo = false;
            boxOne.setIcon(oIcon);
       }
    }