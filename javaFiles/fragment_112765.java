public void actionPerformed(ActionEvent evt) {
  // inside some event listener
  SaveLoad saveload = new SaveLoad(GUI.this);  

  // or just this if not in an inner class then just use this
  // SaveLoad saveload = new SaveLoad(this);  
  // .....
}