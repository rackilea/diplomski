public static void main(String[] args) {
    final JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button = new JButton("Click Me");
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            frame.setSize(200, 200);
        }
    });
    frame.add(panel);
    panel.add(button);
    frame.pack();
    frame.setVisible(true); 
}