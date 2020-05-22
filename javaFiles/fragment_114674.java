public static void main(String[] args) {
    JFrame f = new JFrame();
    JButton button = new JButton("Press keys");
    button.addKeyListener(new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
                System.out.println("You pressed Shift");
            } else {
                System.out.println("You pressed a non-Shift key");
                // [ more logic ]
            }
        }

    });
    f.add(button, BorderLayout.CENTER);
    f.pack();
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}