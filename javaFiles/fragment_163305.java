public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        //Install windows LaF
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton button = new JButton("1");
        button.setBackground(Color.BLUE);
        button.addActionListener(e -> {
            Color newBackground = button.getBackground().equals(Color.RED) ? Color.BLUE : Color.RED;
            button.setBackground(newBackground);
        });

        frame.add(button);

        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    });
}