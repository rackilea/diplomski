public static class Dissplay extends JPanel{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Dissplay() {
        super();
        this.setPreferredSize(new java.awt.Dimension(600, 100));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Please enter you plugin folder location and what you want to install.", 30, 20);
    }
}