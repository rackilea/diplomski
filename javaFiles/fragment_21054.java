JPanel panel = new JPanel(){

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(...);
        g.fill(...);
    }
};
frame.add(panel);