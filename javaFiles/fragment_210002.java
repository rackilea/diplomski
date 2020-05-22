public void keyPressed(KeyEvent arg0) {
    if(pressed==false) {
        pressed=true;
        oldCharacterX = characterX;
        oldCharacterY = characterY;

        //... keypress handling ...

        if (oldCharacterX != characterX  ||  oldCharacterY != characterY) {
            // Only need to repaint old position if it is different from the new
            repaint(oldCharacterX, oldCharacterY, 40, 40);
        }
        repaint(characterX, characterY, 40, 40);
    }
}