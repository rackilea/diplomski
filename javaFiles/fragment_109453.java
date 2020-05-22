public class TextPane    public class TextPane extends JPanel {

    int state;
    boolean stopFlag;
    char ch;
    int xPos;
    String msg = "Islam Hamdy";
    int msgWidth;

    private int direction = 10;

    public TextPane() {
        setBackground(Color.BLACK);
        setForeground(Color.YELLOW);

        setFont(new Font("ALGERIAN", Font.PLAIN, 30));

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xPos += direction;
                FontMetrics fm = getFontMetrics(getFont());
                if (xPos > getWidth()) {
                    direction *= -1;
                } else if (xPos < -fm.stringWidth(msg)) {
                    direction *= -1;
                }
                repaint();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        FontMetrics fm = g2d.getFontMetrics();
        msgWidth = fm.stringWidth(msg);
        g2d.drawString(msg, xPos, 40);
        g2d.dispose();
    }
}