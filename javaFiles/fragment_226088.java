//Movement
void keyPressed() {

  player1.pressed((key == 'w' || key == 'W'), (key == 's' || key == 'S'));
  player2.pressed((keyCode == UP), (keyCode == DOWN));   

  if (key == ' '){start = true;}    

}

void keyReleased() {

  player1.released((key == 'w' || key == 'W'), (key == 's' || key == 'S'));
  player2.released((keyCode == UP), (keyCode == DOWN));

  //if (key == ' ') {start = false;}

}