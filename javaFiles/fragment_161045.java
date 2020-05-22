public void init() {
    //JFrame frame = new JFrame(); 

    JPanel panel = new JPanel(); 
    JScrollPane scrPane = new JScrollPane(panel); 
    scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    //  scrPane.setLayout(new ScrollPaneLayout()); 
    //  frame.getContentPane().add(scrPane); 

    getContentPane().add(scrPane);

    // this.setVisible(true); 
}