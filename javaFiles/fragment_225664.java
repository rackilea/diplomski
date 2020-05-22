class Paint extends JPanel {

    private Font paintFont;

    public Paint() {
        paintFont = new Font("TimesRoman", Font.PLAIN, 15);
        setFont(paintFont);
        getFontMetrics(paintFont);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 10, 10);
        g.setColor(Color.BLACK);
        g.drawLine(100, 100, 100, 200);
        g.drawLine(129, 100, 129, 200);
        if (x > 100 && x < 120) {
            System.out.println("...");
            //g.setFont(paintFont);
            g.setColor(Color.BLACK);
            g.drawString("Sample Text", x - 30, y - 25);
            //g.fillRect(x,y-15,10,10); - This work fine if you remove the g.setFont and the drawString
        }
    }
}