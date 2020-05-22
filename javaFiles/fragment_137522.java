public class Foo {
    private static class Animate extends JPanel {
        private JButton btn;
        private int startX;
        private int startY;
        private long startTime;
        private double ang;
        private double distance;

        public Animate() {
            super();
            setLayout(null);
            btn = new JButton("Dr Horse");
            btn.setBounds(100, 150, 40, 10);
            add(btn);
            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    startX = btn.getX();
                    startY = btn.getY();
                    startTime = System.nanoTime();
                    int px = btn.getX() - e.getX();
                    int py = btn.getY() - e.getY();
                    distance = Math.sqrt(px * px + py * py);
                    ang = Math.toDegrees(Math.atan2(py, px));

                }
            });
            Timer timer = new Timer(1000 / 20, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    double duration = (System.nanoTime() - startTime) / 1e6;
                    int speed = 50;// pixels per second
                    double distanceSoFar = Math.min(speed * duration / 1000d, distance);
                    int x = startX - (int) (distanceSoFar * Math.cos(Math.toRadians(ang)));
                    int y = startY - (int) (distanceSoFar * Math.sin(Math.toRadians(ang)));
                    btn.setLocation(x, y);
                }
            });
            timer.setRepeats(true);
            timer.start();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new Animate());
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

}