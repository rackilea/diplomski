private static void createAndShowGui() {

  // create and display my GUI here

}

public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        createAndShowGui();
     }
  });
}