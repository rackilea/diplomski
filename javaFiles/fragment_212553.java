for(int i = 0; i < MainMenu.numplayers; i++) {
  final TextField textField = new TextField("Player " + (i+1), skin);
  playername[i] = textField;
  // ...

  textField.addListener(new FocusListener() {
    public void keyboardFocusChanged(FocusListener.FocusEvent event, Actor actor, boolean focused) {
        if(focused == true) {
            // Access textField here and below as needed
        }
        else if(focused == false){
            // ...
        }
    }
  });

}