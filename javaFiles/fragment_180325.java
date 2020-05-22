public void gameLoop() {
     while(running) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 Display.sync(60);
                 Display.update();
             }
         });
    }

    Display.destroy();
 }