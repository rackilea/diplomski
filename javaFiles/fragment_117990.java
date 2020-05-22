public void mouseMoved(MouseEvent me)
{
    mouseX = me.getX();
    mouseY = me.getY();
    showStatus("Moving mouse at "+mouseX+", "+mouseY);
}