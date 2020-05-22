boolean b = false;

@Override
public void keyPressed(KeyEvent arg0) {
     if(!b){
          //do stuff
     }
     b = true;
}

@Override
public void keyReleased(KeyEvent arg0) {
     b = false;
}