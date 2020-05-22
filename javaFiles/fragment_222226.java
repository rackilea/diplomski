SwingUtilities.invokeLater(new Runnable(){
    @Override
    public void run(){
        text.getHighLighter().removeAllHighLights();
    }
});