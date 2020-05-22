class MyMouseListener implements MouseListener{
@Override
public void mouseReleased(MouseEvent arg0) {
    if(SwingUtilities.isRightMouseButton(arg0)&&clickButton.isEnabled()){
        //my code
    }
}