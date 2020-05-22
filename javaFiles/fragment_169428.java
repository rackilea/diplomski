private JPanel panel_1 = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        paintComponents(g);
        panel_1.setBackground(Color.orange);
        panel_1.setVisible(true);

        System.out.println("Just testing");
    }
};