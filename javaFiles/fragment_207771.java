public class MyFrame extends JFrame {
  private MyPanel myPanel = new MyPanel();

  public MyFrame() {
    this.add(myPanel);

    JButton someButton = new JButton("Do It!");
    someButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        String text = MyFrame.this.myPanel.getText();

        // Do something with the text
      }
    });
  }
}