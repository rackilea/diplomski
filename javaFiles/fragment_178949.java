MouseListener listen = new MouseListener()
{
    void mouseClicked(MouseEvent e){}
    void mouseReleased(MouseEvent e){}
    void mousePressed(MouseEvent e){paintGUI.repaint();}
    void mouseExited(MouseEvent e){}
    void mouseEntered(MouseEvent e){}
};
paintGUI.addMouseListener(listen);