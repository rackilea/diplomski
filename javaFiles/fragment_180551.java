class DamClass2 {
   private JTextField field1 = new JTextField(10);
   private JTextField field2 = new JTextField(10);
   private JPanel panel = new JPanel();

   public DamClass2() {
      panel.add(new JLabel("Searched For:"));
      panel.add(field1);
      panel.add(new JLabel("Second word:"));
      panel.add(field2);
      panel.setLayout(new GridLayout(5, 2));
   }

   public JPanel getPanel() {
      return panel;
   }

   public void setField1(String text) {
      field1.setText(text);
   }

   public void setField2(String text) {
      field2.setText(text);
   }
}