final JPanel panel = new JPanel(); //create it on your custom way...
panel.addComponentListener(new ComponentAdapter() {

    @Override
    public void componentResized(ComponentEvent e){
        int w = b.getWidth();
        int h = b.getHeight();            
        setIconSize(w,h); //TODO by yourself (sorry, if more help required please say so)
    }
});