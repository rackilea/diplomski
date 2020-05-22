class CustomMouseOverJLabel extends JLabel{
    public CustomMouseOverJLabel(String text) {
        super(text);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.BLUE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(Color.RED);
            }               
        });
    }       
}