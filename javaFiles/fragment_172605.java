public void keyReleased(KeyEvent e) {
    //your code for getting key event and finding the player Object

    if(key == KeyEvent.VK_SPACE) {
        //Do any necessary cleanup of the firing here
        tempObject.setFiring(false);
    }
}