String text = "";
boolean helloReceived = false;

void draw(){
  background(64);
  textAlign(CENTER, CENTER);
  text(text, width/2, height/2);
}

void keyPressed(){
  text += key;

  if(text.equals("hello")){
     helloReceived = true; 
  }
}

void mousePressed(){

  if(helloReceived){
    println("Text now equals hello!");
  }
}