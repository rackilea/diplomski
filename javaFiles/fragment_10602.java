String text = "";

void draw(){
  background(64);
  textAlign(CENTER, CENTER);
  text(text, width/2, height/2);
}

void keyPressed(){
  text += key;
}

void mousePressed(){

  while(!text.equals("hello")){
    println("Waiting for text to equal hello.");
    delay(1000);
  }

}