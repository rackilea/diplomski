@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
  SwingUtilities.invokeLater(
      new Runnable() { 
         public void run() {
            FileCl.go(JTip.getText());
         }
      }
   );
}