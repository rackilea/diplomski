public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run()
      {
        JFrame frame = new JFrame("Password Login System");
        frame.setSize(400, 100);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Password: ");
        JPasswordField pass = new JPasswordField(10);
        pass.setEchoChar('*');
        pass.addActionListener(new AL());
        panel.add(label, BorderLayout.WEST);
        panel.add(pass, BorderLayout.EAST);
        frame.add(panel);
        frame.validate();
      }
    });
  }