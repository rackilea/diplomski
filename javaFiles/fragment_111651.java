public class MyClass implements ActionListener {
   JComboBox comboBox = ...;

   ...
       // You must register explicitly every ActionListener that you
       // want to receive ActionEvent's from comboBox.
       // Here we register this instance of MyClass.
       comboBox.addActionListener(this);
   ...

   @Override 
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() instanceof JComboBox) {
         System.out.println("MyClass registered an ActionEvent from a JComboBox.");
         System.out.println("Selected: " + 
               ((JComboBox) e.getSource()).getSelectedItem());
      }
   }
}