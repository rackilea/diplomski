public void paintComponent(Graphics g) {
    clear(g);
    Graphics2D g2d = (Graphics2D)g;
    g2d.fill(square);
    g2d.draw(square1);
    Button bonjourButton = new Button("Bonjour");
    g.add(bonjourButton, BorderLayout.NORTH); 
    b.setActionCommand("Good Morning"); 
    b.addActionListener(a);
    Button goodDayButton = new Button("Good Day"); 
    g.add(goodDayButton, BorderLayout.CENTER); 
    b.addActionListener(a); 
    Button aurevoirButton = new Button("Aurevoir");
    g.add(aurevoirButton, BorderLayout.SOUTH); 
    b.setActionCommand("Exit"); 
    b.addActionListener(a); 
    g.pack(); 
    g.show(); 
}