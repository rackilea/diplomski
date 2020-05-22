public void mouseToPosition(int x, int y){
    int zeroPosX = myApplet.getLocation().getX();
    int zeroPosY = myApplet.getLocation().getY();

    int newPosX = zeroPosX + x;
    int newPosY = zeroPosY + y;

    ...
    //now you have to check if it's in the bounds of the Applet, maybe throw an error
    //and you can add your click/move/whatever robot logic
}