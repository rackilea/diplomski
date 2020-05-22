private class EnterKeyHandler implements KeyDownHandler {

    public void onKeyDown(KeyDownEvent event) { 
          if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) { 
             textbox = (TextBox) event.getSource();
              Window.alert("enter" + textbox.getText());
             List.add(textbox.getText()); //adds the word to an array 
          }
    }