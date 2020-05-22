public class ChineseFont {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      String text = "test  test 漢字.";

      JTextField textField1 = new JTextField(text);
      textField1.setFont(new Font("Arial Unicode MS", Font.PLAIN, 24));
      JLabel label1 = new JLabel("JTextField " + textField1.getFont().getFontName());

      JTextField textField2 = new JTextField(text);
      textField2.setFont(new Font("MingLiU", Font.PLAIN, 24));
      JLabel label2 = new JLabel("JTextField " + textField2.getFont().getFontName());

      JTextField textField3 = new JTextField(text);
      textField3.setFont(new Font("MingLiU-ExtB", Font.PLAIN, 24));
      JLabel label3 = new JLabel("JTextField " + textField3.getFont().getFontName());

      JTextPane  textPane4 = new JTextPane();
      textPane4.setFont(new Font("Arial Unicode MS", Font.PLAIN, 24));
      textPane4.setText(text);
      JLabel label4 = new JLabel("JTextPane " + textPane4.getFont().getName());

      JTextPane  textPane5 = new JTextPane();
      textPane5.setFont(new Font("MingLiU", Font.PLAIN, 24));
      textPane5.setText(text);
      JLabel label5 = new JLabel("JTextPane " + textPane5.getFont().getName());

      JFrame frame = new JFrame();
      Container contentPane = frame.getContentPane();
      contentPane.setLayout(new GridLayout(5, 2, 2, 6));
      contentPane.add(label1);
      contentPane.add(textField1);
      contentPane.add(label2);
      contentPane.add(textField2);
      contentPane.add(label3);
      contentPane.add(textField3);
      contentPane.add(label4);
      contentPane.add(textPane4);
      contentPane.add(label5);
      contentPane.add(textPane5);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
    });
  }
}