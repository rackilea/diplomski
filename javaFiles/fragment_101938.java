public class BadPaint05 {

    public static void main(String[] args) {
        new BadPaint05();
    }

    public BadPaint05() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MasterPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MasterPane extends JPanel {

        private DrawPanel drawPane;
        private Timer timer;

        public MasterPane() {
            setLayout(new BorderLayout());
            drawPane = new DrawPanel();

            add(drawPane);

            JButton stop = new JButton("Stop");
            stop.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    drawPane.clearEvent(e);
                    timer.stop();
                }
            });

            timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawPane.addRect();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();

            add(stop, BorderLayout.SOUTH);

        }

    }

    class DrawPanel extends JPanel {

        ArrayList<MyRectangle> rects = new ArrayList<>();
        Random rand = new Random();

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);

//            addRect();

            for (MyRectangle r : rects) {
                g.setColor(r.getColor());
                g.fillRect(r.x, r.y, r.width, r.height);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        public ArrayList<MyRectangle> addRect() {
            int ht = rand.nextInt(getHeight());
            int wd = rand.nextInt(getWidth());

            int x = rand.nextInt(getWidth() - wd);
            int y = rand.nextInt(getHeight() - ht);

            int r = rand.nextInt(256);
            int g = rand.nextInt(256);
            int b = rand.nextInt(256);

            rects.add(new MyRectangle(x, y, wd, ht, new Color(r, b, g)));
            System.out.println(rects.size());
            repaint();
            return rects;
        }

        public void clearEvent(ActionEvent e) {
            System.out.println(rects.size());
            rects.clear();
//            frame.repaint();
            repaint();
            System.out.println("I was called");
        }
    }

    public class MyRectangle {

        private int x, y, width, height;
        private Color color;

        private MyRectangle(int x, int y, int wd, int ht, Color color) {
            this.x = x;
            this.y = y;
            this.width = wd;
            this.height = ht;
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

    }
}