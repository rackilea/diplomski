class Talk extends javax.swing.JFrame    {

public static void main(String args[]) {
    JFrame frame = new JFrame("LET'S TALK");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    JLabel textLabel=new JLabel("What's up.",SwingConstants.CENTER);
    textLabel.setPreferredSize(new Dimension(530,100));
    frame.getContentPane().add(textLabel, BorderLayout.CENTER);
    frame.setLocationRelativeTo(null);

    JButton button=new JButton("OK");
    JPanel panel1=new JPanel();
    JTextField textField = new JTextField(8);

    panel1.add(button);
    panel1.add(textField);
    frame.add(panel1, BorderLayout.SOUTH);

    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField.setText("welcome");
        }
    });

    frame.pack();
    frame.setVisible(true);
  }
}