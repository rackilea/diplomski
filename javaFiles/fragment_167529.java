public void init() {
    initComponents();
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            showCircle();
        }
    });
}

private boolean circleIsVisible = false; 
private void showCircle() {
    circleIsVisible = true;
    repaint();
}

public void paint(Graphics g) {
    super.paint(g);
    if (circleIsVisible) {
        g.setColor(Color.red);
        g.fillOval(140, 140, 20, 20);
    }
}