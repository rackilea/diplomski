Point p;

courtPanel.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e){
        p = e.getLocationOnScreen();
        repaint();   
    }
});