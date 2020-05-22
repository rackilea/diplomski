java.awt.EventQueue.invokeLater(new Runnable() {
     public void run() {
        Cifra cifra = new Cifra();
        cifra.setVisible(true);
        cifra.setAntMexText("Hello World!" + NEW_LINE); // NEW_LINE should be all caps
        cifra.appendAntMexText("Next Line");
     }
  });