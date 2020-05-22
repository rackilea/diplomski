private static void bringToFront() {                                                             
    getInstance().setVisible(true);                                                              
    getInstance().setExtendedState(JFrame.NORMAL);                                               
    getInstance().toFront();                                                                     
    getInstance().repaint();                                                                     
}