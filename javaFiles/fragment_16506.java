if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
    if(wKeyUp==true) {
      wKeyUp = false;

      executeCode();
      }
   } else if (wKeyUp == false && !Keyboard.isKeyDown(Keyboard.KEY_W))
        wKeyUp = true;