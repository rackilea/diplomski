frame.add(new JComponent() {//anonymous class will extend JComponent 
                            //in same way MyComponent does
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.drawString("Hello", 100, 100);
    }
});