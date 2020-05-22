private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setBounds(100, 100, 640, 480);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new MigLayout("", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]", "[14.28%][14.28%][14.28%][14.28%][14.28%][14.28%][14.28%]"));
    frame.setVisible(true);
    for (int row = 0; row<7; row++) {
        for (int col = 0; col<10; col++) {
            JButton b = new JButton();
            frame.getContentPane().add(b, "cell "+ col +" "+ row +",grow");
            // click method
            frame.getContentPane().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent arg0) {
                    // code
                }
            });
        }
    }
}