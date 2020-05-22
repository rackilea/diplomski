private void mainGameLoop(){
 while(pause==false){
  updateLogic();//process movement, detect collisions etc
  renderGraphics();//draw a new frame
  try{Thread.sleep(25);}catch(InterruptedException e){e.printStackTrace();}//sleep the thread to control the frame rate. (there are more efficient ways to sleep a thread but this is the most simplistic)
 }
}