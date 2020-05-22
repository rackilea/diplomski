public static void main(String[] args){

    // start your NativeInterface here!
    NativeInterface.open(); // not sure what else may be needed for this

    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        WebPageDisplay display = new WebPageDisplay();
      }
    });
}