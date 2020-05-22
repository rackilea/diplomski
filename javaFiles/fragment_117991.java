public void mouseMoved(MouseEvent me)
{
    int currentMouseX = me.getX();
    int currentMouseY = me.getY();
    showStatus("Moving mouse at "+currentMouseX+", "+currentMouseY);
}