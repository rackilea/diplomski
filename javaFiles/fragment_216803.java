// create key listener
addKeyListener(new KeyListener()
    {
          @Override 
          public void keyPressed(KeyEvent e)
          {         
              int keyCode = e.getKeyCode();
              String event = KeyEvent.getKeyText(keyCode);


              if (event.equals("A")) {
                  // DO YOUR EVENT IF THE KEY HAS BEEN PRESSED
                  action = "A";
              }
          }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {
              int keyCode = e.getKeyCode();
              String event = KeyEvent.getKeyText(keyCode);


              if (event.equals("A")) {
                  // STOP DOING YOUR EVENT
                  action = "";
              }

         }

    });