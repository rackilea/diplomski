while (true) {
    try {
        Thread.sleep(1000);
        colorPanel.repaint();
    } catch(InterruptedException e){//from sleep
        return;//i.e. stop
    } catch (Exception ex) {
        //do Nothing
    }
}