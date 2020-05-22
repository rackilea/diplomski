public void warningMassage(String yourText){
    int n = JOptionPane.showConfirmDialog(
            frame,
            yourText,
            "Warning",
            JOptionPane.YES_NO_OPTION);
    System.out.println(n);
      if(n == JOptionPane.YES_OPTION){
          frame.setVisible(true);
      }
      else{
          System.exit(0);
          System.out.println(JOptionPane.YES_OPTION);
      }
}//warningMassage