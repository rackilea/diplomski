public class Reverse extends JApplet {

    // Set colors and initialize thread.
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                setBackground(Color.BLACK);
                setForeground(Color.YELLOW);
                setLayout(new BorderLayout());
                add(new TextPane());
            }
        });
    }

    // Start thread
    public void start() {
    }

    // Pause the banner.
    public void stop() {
    }

    public class TextPane extends JPanel {

        int state;
        boolean stopFlag;
        char ch;
        int xPos;
        String masterMsg = "Islam Hamdy", temp = "";
        String msg = masterMsg;
        String revMsg;
        int msgWidth;

        private int direction = 10;

        public TextPane() {
            setOpaque(false);
            setBackground(Color.BLACK);
            setForeground(Color.YELLOW);

            setFont(new Font("ALGERIAN", Font.PLAIN, 30));

            // This only needs to be done one...
            StringBuilder sb = new StringBuilder(masterMsg.length());
            for (int index = 0; index < masterMsg.length(); index++) {
                sb.append(masterMsg.charAt((masterMsg.length() - index) - 1));
            }
            revMsg = sb.toString();

            // Main animation engine.  This is responsible for making
            // the decisions on where the animation is up to and how
            // to react to the edge cases...
            Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xPos += direction;
                    FontMetrics fm = getFontMetrics(getFont());
                    if (xPos > getWidth()) { // this condition fires when the text banner reaches the right banner
                        direction *= -1;
                        msg = revMsg;
                    } else if (xPos < -fm.stringWidth(masterMsg)) {
                        direction *= -1;
                        msg = masterMsg;
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
            System.out.println(xPos);
            FontMetrics fm = g.getFontMetrics();
            msgWidth = fm.stringWidth(msg);
            g.drawString(msg, xPos, 40);
        }
    }
}