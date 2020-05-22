for (Button b: buttonsList){
    if (src == b) {
        if (firstPlayer) {
            b.setIcon(playerO);
            firstPlayer = false;
        } else {
            b.setIcon(playerX);
            firstPlayer = true;
        }
    }
}