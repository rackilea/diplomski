public class gamemain extends JPanel {

    public boolean paused = true;

    int[][] worldsize = new int[1000][1000];
    world playspace = new world(worldsize);

    Timer timer = new Timer(250, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("Debug: timer ticked");
            playspace.updateWorldState();
            repaint();

        }

    });

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        System.out.println("Hit painter");
        g.drawString("Test", 50, 50);

        for(int i = 0; i < 999; i++) {
            for(int j = 0; j < 999; i++) {
                if(playspace.getWorldStateAt(i, j) == 1) {
                    g.drawRect(i, j, 1, 1);
                }
            }
        }

    }

    //...

    public static void main(String[] args) throws InterruptedException {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame gui = new JFrame();
                gui.setTitle("Game of Life");
                gui.setSize(1000, 1000);
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gamemain panel = new gamemain();
                panel.addKeyListener(new listener());
                panel.addMouseListener(new mouselistener());
                panel.setBackground(Color.WHITE);
                panel.setOpaque(true);
                Container pane = gui.getContentPane();
                pane.add(panel);
                gui.setVisible(true);
                panel.requestFocus();
            }
        });


    }

}