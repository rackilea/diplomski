public void keyListener(KeyEvent event){
    if(event.getCode() == KeyCode.ENTER) {
          // Do stuff
          ((TextField)event.getSource()).clear(); // clear textfield
          System.out.println("Enter Pressed"); // print a message
     }
}