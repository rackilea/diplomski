private int num1, num2, width = 0, g1;

public Main() {
    this.setTitle("Progressbar with rectangles");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setResizable(true);

    Main main  = this;

    Thread t = new Thread( new Runnable() {
        public void run() {

            for(width=0; width<300; width++) {

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {

                        main.repaint();
                    }
                });


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    t.start();
}

@Override
public void paint(Graphics g) {

    super.paint(g);

    g.setColor(Color.RED);
    g.drawRect(40, 40, 300, 20);

    g.setColor(Color.BLACK);

    g.fillRect(40, 40, width, 20);

}

public static void main(String[] args) {
    Main m = new Main();
}