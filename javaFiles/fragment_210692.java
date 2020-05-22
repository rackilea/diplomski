protected void processWindowEvent(WindowEvent e){
    if(e.getID() == WindowEvent.WINDOW_CLOSING) {
        try{_wg._grab.release();}
        catch(Exception ee){}
    }
    super.processWindowEvent(e);
}