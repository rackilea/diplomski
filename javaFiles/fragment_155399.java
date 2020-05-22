public static void main(String[] args) {

    final JFrame frame = new JFrame("Test");
    frame.setLayout(new GridLayout(0, 1));

    frame.add(new JButton(new AbstractAction("Click to add") {
        @Override
        public void actionPerformed(ActionEvent e) {

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.add(new JLabel("Bla"));
                    frame.validate();
                    frame.repaint();
                }
            });
        }
    }));

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    SwingUtilities.invokeLater(new Runnable() {
        @Override public void run() {
            frame.setVisible(true);
        }
    });
}