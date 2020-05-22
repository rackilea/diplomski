public void showWindow() {   
    window.setVisible(false);
    location = myTextField.getLocationOnScreen();
    int x = location.x;
    int y = location.y;
    window.setLocation(x - 20, y - 20);
    Runnable doRun = new Runnable() {

         @Override
         public void run() {
             window.setVisible(true);
         }
    };
    SwingUtilities.invokeLater(doRun);
 }