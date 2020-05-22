public static void main(String [] args) {
    // Construct main Frame on Swing EDT thread
    Thread thread = new Thread() {
        public void run() {
          // now the background init stuff
          new com.yourcompany.view.Dialog1();
          new com.yourcompany.view.WizardGUI();
          new com.yourcompany.view.SecondaryFrame();
         // Here all the views are loaded and initialized
        }
     };

     JFrame mainFrame = new JFrame();
     mainFrame.setVisible();
     // etc.
 }