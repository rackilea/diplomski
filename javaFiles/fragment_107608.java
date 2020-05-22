// class field
private boolean canClose = false;

//....

WindowAdapter waReturnToMenu = new WindowAdapter() {
   @Override
   public void windowClosing(final WindowEvent e) {
        if (canClose) {
           System.exit(0);
        } else {
           changeMenuState(0);
        }
   }
};