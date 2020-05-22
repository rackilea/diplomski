myframe.addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(WindowEvent winEvt) {
        updateZonas();
        //db.close();
        //System.exit(0);
    }
});