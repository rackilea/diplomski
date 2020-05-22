public static void main(String[] args) {

    final JFrame frame = new JFrame("Application Close Example");

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
      for (int i = 5; i < 8; i++) {
         buttons[i] = new JButton(Integer.toString(i));
            bottomPanel.add(buttons[i]);
      }

    frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);

    frame.pack();
    frame.setVisible(true);
}