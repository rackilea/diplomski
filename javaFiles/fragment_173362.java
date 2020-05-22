public static void main(String[] args){
   try {
      // Set cross-platform Java L&F (also called "Metal")
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      // alternatively, the following should load the default L&F for your system
      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
   } catch (Exception e) {}

   TicTacToe play = new TicTacToe();
}