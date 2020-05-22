class MyPanel extends JPanel {
   private MainForm myMainForm; // holds the reference to the current MainForm object

   public MyPanel(MainForm myMainForm) {
      this.myMainForm = myMainForm; // set the reference

      JButton swapPanelBtn = new JButton("Swap Panel");
      swapPanelBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            swapPanelBtnActionPerformed();
         }
      });
   }

   private void swapPanelBtnActionPerformed() {
      myMainForm.swapJPanels(0); // calling a method on the reference to the current MainForm object
   }
}