for(int x = 0; x < delButton.length; x++) {     
    final index = x;                     
    delButton[x].setOnAction(new EventHandler<ActionEvent>() {     
        public void handle(ActionEvent event) {
            delButton[index] = null;
        }
    });
}