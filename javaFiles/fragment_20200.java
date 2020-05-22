public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {
        @Override

        public void run() {
            JPanel panel = new JPanel(new GridBagLayout());

            JButton nb1 = new JButton("Button1  ");
            JButton nb2 = new JButton("Button2  ");

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(nb1, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            panel.add(nb2, gbc);

            JFrame frame = new JFrame("Address Book ");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(panel);

            frame.pack();
            frame.setVisible(true);
        }
    });
}