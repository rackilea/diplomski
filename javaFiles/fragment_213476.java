private void jButton3ActionPerformed(ActionEvent e) {
  mp3.FastForward();
  bar+=5; // increment bar before checking complete, and before setting progress
  if(mp3.player.isComplete()){
    bar = 100;
  }
  jProgressBar1.setValue((int)bar);
}