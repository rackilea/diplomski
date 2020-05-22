public class MyPanel extends JPanel {
  private JTextField field1 = new JTextField(10);
  // .... other fields ? ...

  public MyPanel() {
     add(new JLabel("Field 1:");
     add(field1);
  }

  public String getField1Text() {
    return field1.getText();
  }

  // .... other getters for other fields
}