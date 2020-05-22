public class CloseListener implements WindowListener {
    // im not interest  on this event, but still need to override it
    @Override
    public void windowOpened(WindowEvent e) {

    }
    // im not interest  on this event, but still need to override it    
    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);

    }
    // im not interest  on this event, but still need to override it    
    @Override
    public void windowIconified(WindowEvent e) {

    }
    // im not interest  on this event, but still need to override it
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

}