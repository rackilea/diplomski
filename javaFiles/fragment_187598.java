final JPanel panel = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // your custom painting code here
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(..., ...);
    }
};